package ec.edu.espe.clinicmanagementsystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */
public class MongoConnection {

    private static MongoConnection instance;
    
    private MongoClient mongoClient;
    private MongoDatabase database;

    private MongoConnection() {
        String uri = "mongodb+srv://Cesar:Cesar2006@cluster0.tgbv2qc.mongodb.net/";
        try {
            this.mongoClient = MongoClients.create(uri);
            this.database = mongoClient.getDatabase("toamedicalDB");
            System.out.println("Conexión a MongoDB establecida exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al conectar con MongoDB: " + e.getMessage());
        }
    }

    public static MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
            instance = null; 
        }
    }
}
