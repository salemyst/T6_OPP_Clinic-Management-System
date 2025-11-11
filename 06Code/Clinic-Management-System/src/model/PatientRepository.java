
package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class PatientRepository {
    
    private ObjectMapper objectMapper;
    private String filePath;

    public PatientRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        // Habilitar formato "pretty print" (JSON legible)
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // NO necesitamos JavaTimeModule porque usamos nuestra propia clase Date
    }

    /**
     * Carga la lista de pacientes desde el archivo JSON.
     */
    public List<Patient> loadPatients() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>(); // Retorna lista vacía si el archivo no existe
        }

        try {
            // Lee el archivo y lo convierte a una Lista de Pacientes
            return objectMapper.readValue(file, new TypeReference<List<Patient>>() {});
        } catch (IOException e) {
            System.err.println("Error al cargar pacientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Guarda la lista completa de pacientes en el archivo JSON.
     */
    public void savePatients(List<Patient> patients) {
        try {
            // Escribe la lista de pacientes en el archivo
            objectMapper.writeValue(new File(filePath), patients);
        } catch (IOException e) {
            System.err.println("Error al guardar pacientes: " + e.getMessage());
        }
    }
}
