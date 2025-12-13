package ec.edu.espe.clinicmanagementsystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.clinicmanagementsystem.model.Date;
import java.text.SimpleDateFormat;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */
public class MongoManager {

    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoManager() {
        String uri = "mongodb+srv://Cesar:Cesar2006@cluster0.tgbv2qc.mongodb.net/";
        this.mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase("toamedicalDB");
    }

    public void insert(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
        System.out.println("Documento insertado correctamente en: " + collectionName);
    }

    public List<Document> getAll(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find().into(new ArrayList<>());
    }

    public List<Document> find(String collectionName, Document filter) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(filter).into(new ArrayList<>());
    }

    public Document findById(String collectionName, String idHex) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        try {
            ObjectId objectId = new ObjectId(idHex);
            return collection.find(new Document("_id", objectId)).first();
        } catch (IllegalArgumentException e) {
            System.err.println("El ID proporcionado no es válido: " + idHex);
            return null;
        }
    }

    public long update(String collectionName, Document filter, Document newData) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document operation = new Document("$set", newData);

        UpdateResult result = collection.updateOne(filter, operation);

        if (result.getModifiedCount() > 0) {
            System.out.println("Se actualizó el documento exitosamente.");
        } else {
            System.out.println("No se encontraron documentos para actualizar o los datos eran iguales.");
        }
        return result.getModifiedCount();
    }

    public long delete(String collectionName, Document filter) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        DeleteResult result = collection.deleteOne(filter);

        if (result.getDeletedCount() > 0) {
            System.out.println("Documento eliminado exitosamente.");
        } else {
            System.out.println("No se encontró el documento para eliminar.");
        }
        return result.getDeletedCount();
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión cerrada.");
        }
    }

    public String dateFormated(Object rawDate, boolean mostrarHora) {
        if (rawDate == null) {
            return "Sin datos";
        }
        
        if (rawDate instanceof Document) {
            Document doc = (Document) rawDate;
            try {
                int dia = doc.getInteger("day");
                int mes = doc.getInteger("month");
                int anio = doc.getInteger("year");
                int hora = doc.containsKey("hour") ? doc.getInteger("hour") : 0;
                int min = doc.containsKey("minute") ? doc.getInteger("minute") : 0;

                if (mostrarHora) {
                    return String.format("%02d:%02d", hora, min);
                } else {
                    return String.format("%02d/%02d/%04d", dia, mes, anio);
                }
            } catch (Exception e) {
                return "Error Formato";
            }
        }
        if (rawDate instanceof Date) {
            Date date = (Date) rawDate;
            SimpleDateFormat sdf = mostrarHora
                    ? new SimpleDateFormat("HH:mm")
                    : new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(date);
        }
        return rawDate.toString();
    }
}
