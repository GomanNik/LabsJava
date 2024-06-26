import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class FlatSerializationModuleTest {

    @Test
    void testFlatSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper = new ObjectMapper().registerModule(new FlatSerializationModule(mapper));


        List<Person> owners = new ArrayList<>();
        owners.add(new Person("Иван", "Иванов", "Иванович", "1990-12-25"));
        Flat flat = new Flat(101, 120.5f, owners);

        String expectedJson = "{\"number\":101,\"area\":120.5," +
                "\"owners\":[{\"fullName\":\"Иван Иванов Иванович\",\"dateOfBirth\":\"1990-12-25\"}]}";

        String actualJson = mapper.writeValueAsString(flat);

        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testFlatDeserialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FlatSerializationModule(mapper));

        String json = "{\"number\":101,\"area\":120.5,\"owners\":[{\"fullName\":\"Иван Иванов Иванович\",\"dateOfBirth\":\"1990-12-25\"}]}";
        Flat actualFlat = mapper.readValue(json, Flat.class);

        List<Person> expectedOwners = new ArrayList<>();
        expectedOwners.add(new Person("Иван", "Иванов", "Иванович", "1990-12-25"));
        Flat expectedFlat = new Flat(101, 120.5f, expectedOwners);

        assertEquals(expectedFlat.getNumber(), actualFlat.getNumber());
        assertEquals(expectedFlat.getArea(), actualFlat.getArea(), 0.001);
        assertEquals(expectedFlat.getOwners(), actualFlat.getOwners());
    }

}