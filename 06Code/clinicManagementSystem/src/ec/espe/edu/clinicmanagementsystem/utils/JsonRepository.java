package ec.espe.edu.clinicmanagementsystem.utils;
/**
 *
 * @author César Vargas, Paradigm, @ESPE
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository<T> {

    private final String filename;
    private final Gson gson;
    private final Type listType; 

    public JsonRepository(String filename, Type listType) {
        this.filename = filename;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listType = listType;
    }

    public void saveData(List<T> data) {
        String json = gson.toJson(data, listType);
        try (Writer writer = new FileWriter(filename)) {
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Error al guardar en " + filename + ": " + e.getMessage());
        }
    }

    public List<T> loadData() {
        File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(filename)) {
            List<T> data = gson.fromJson(reader, listType);
            
            if (data == null) {
                return new ArrayList<>();
            }
            return data;
            
        } catch (IOException e) {
            System.err.println("Error al cargar " + filename + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get(filename));
        } catch (IOException e) {
            System.err.println("Error al eliminar " + filename + ": " + e.getMessage());
        }
    }
}