
package ec.edu.espe.clinicmanagementsystem.utils;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Adrian Toapanta, Object Masters, @ESPE
 */
public class MongoManagerTest {
    

    @InjectMocks
    private MongoManager mongoManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }



    @Test
    void testCreateDateDocument_ValidDate() {
        Date date = new Date(); 
        Document result = mongoManager.createDateDocument(date, 14, 30);
        
        assertNotNull(result);
        assertEquals(14, result.getInteger("hour"));
        assertEquals(30, result.getInteger("minute"));
        assertTrue(result.containsKey("date"));
        fail();
    }

    @Test
    void testCreateDateDocument_NullDate() {
        Document result = mongoManager.createDateDocument(null, 10, 10);
        assertNull(result);
    }

    @Test
    void testDateFormated_WithDocumentDateOnly() {
        Document dateDoc = new Document("day", 15)
                .append("month", 5)
                .append("year", 2023);
        
        String formatted = mongoManager.dateFormated(dateDoc, false);
        assertEquals("15/05/2023", formatted);
    }

    @Test
    void testDateFormated_WithDocumentTimeOnly() {
        Document dateDoc = new Document("hour", 9)
                .append("minute", 5)
                .append("day", 1) 
                .append("month", 1)
                .append("year", 2023);
        
        String formatted = mongoManager.dateFormated(dateDoc, true);
        assertEquals("09:05", formatted);
        fail();
    }

    @Test
    void testDateFormated_NullInput() {
        String result = mongoManager.dateFormated(null, false);
        assertEquals("Sin datos", result);
    }

    @Test
    void testFindById_InvalidHexId() {

        Document result = mongoManager.findById("anyCollection", "123-invalid");
        assertNull(result);
    }

    @Test
    void testInsert_NotNullDocument() {
        Document doc = new Document("name", "Test");
        assertDoesNotThrow(() -> mongoManager.insert("testCollection", doc));
        fail();
    }

    @Test
    void testGetAll_ReturnsList() {

        try {
            List<Document> list = mongoManager.getAll("patients");
            assertNotNull(list);
        } catch (Exception e) {

            assertTrue(true); 
            fail();
        }
    }

    @Test
    void testUpdate_NegativeResponseOnFailure() {
        Document filter = new Document("id", 1);
        Document data = new Document("status", "updated");
        

        assertThrows(Exception.class, () -> {
            mongoManager.update(null, null, null);
        });
    }

    @Test
    void testClose_DoesNotThrow() {
        assertDoesNotThrow(() -> mongoManager.close());
    }
    @Test
void testDateFormated_IncompleteDocument_ReturnsError() {

    Document incompleteDoc = new Document("year", 2023);

    String result = mongoManager.dateFormated(incompleteDoc, false);


    assertEquals("Error Formato", result, "Debería retornar 'Error Formato' si faltan campos obligatorios");
}
}


