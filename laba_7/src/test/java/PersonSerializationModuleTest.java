import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonSerializationModuleTest {

    @Test
    void testPersonSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new PersonSerializationModule());
        Person person = new Person("Иван", "Иванов", "Иванович", "1990-12-25");
        String expectedJson = "{\"fullName\":\"Иван Иванов Иванович\",\"dateOfBirth\":\"1990-12-25\"}";

        String actualJson = mapper.writeValueAsString(person);

        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testPersonDeserialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new PersonSerializationModule());
        String json = "{\"fullName\":\"Иван Иванов Иванович\",\"dateOfBirth\":\"1990-12-25\"}";
        Person person = mapper.readValue(json, Person.class);
        Person expected = new Person("Иван", "Иванов", "Иванович", "1990-12-25");
        assertEquals(expected,person);
    }
    @Test
    void testPersonSerializationWithEmptyFields() throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new PersonSerializationModule());
        Person person = new Person("", "", "", "1990-12-25");
        String expectedJson = "{\"fullName\":\"  \",\"dateOfBirth\":\"1990-12-25\"}";

        String actualJson = mapper.writeValueAsString(person);

        assertEquals(expectedJson, actualJson);
    }

    @Test
    void testPersonSerializationWithNullFields() throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new PersonSerializationModule());
        Person person = new Person(null, null, null, "1990-12-25");
        String expectedJson = "{\"fullName\":\"null null null\",\"dateOfBirth\":\"1990-12-25\"}";

        String actualJson = mapper.writeValueAsString(person);

        assertEquals(expectedJson, actualJson);
    }

}