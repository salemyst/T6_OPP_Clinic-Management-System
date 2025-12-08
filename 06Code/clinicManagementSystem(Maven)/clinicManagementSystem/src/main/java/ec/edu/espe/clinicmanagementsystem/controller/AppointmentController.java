package ec.edu.espe.clinicmanagementsystem.controller;

/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.clinicmanagementsystem.model.Appointment;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
public class AppointmentController {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Appointment> collection;

    public AppointmentController() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        String connectionString = "mongodb+srv://Cesar:Cesar2006@cluster0.tgbv2qc.mongodb.net/";

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .codecRegistry(codecRegistry)
                .build();

        this.mongoClient = MongoClients.create(clientSettings);
        this.database = mongoClient.getDatabase("toamedicalDB"); 
        
        this.collection = database.getCollection("appointments", Appointment.class);
    }

    public boolean saveAppointment(Appointment appt) {
        try {
            collection.insertOne(appt);
            System.out.println("Cita guardada en Atlas: " + appt.toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }
    
    public void close() {
        mongoClient.close();
    }
}