import com.fasterxml.jackson.core.JsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class HouseSerializationModuleTest {

    @Test
    void testHouseSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new HouseSerializationModule(mapper));

        List<Person> owners = Arrays.asList(
                new Person("Иванов", "Иван", "Иванович", "1990-12-25"),
                new Person("Петров", "Пётр", "Петрович", "1992-03-17"),
                new Person("Сидоров", "Кирилл", "Анатольевич", "2000-09-06")
        );
        List<Flat> flats = Arrays.asList(
                new Flat(1, 150, owners),
                new Flat(2, 150, owners),
                new Flat(3, 150, owners)
        );
        House house = new House("47:14:1203001:814", "г.Городской, ул.Горького, д.34",
                new Person("Самый", "Главный", "Управдом", "2000-01-20"), flats);

        String json = mapper.writeValueAsString(house);

        String expected =
                "{\"cadastralId\":\"47:14:1203001:814\",\"address\":\"г.Городской, ул.Горького, д.34\"," +
                "\"houseElder\":{\"fullName\":\"Самый Главный Управдом\",\"dateOfBirth\":\"2000-01-20\"}," +
                "\"flats\":[" +
                        "{\"number\":1,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}," +
                        "{\"number\":2,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}," +
                        "{\"number\":3,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}]}";
        assertEquals(expected,json);
    }
    @Test
    void testHouseDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new HouseSerializationModule(mapper));

        String json =
                "{\"cadastralId\":\"47:14:1203001:814\",\"address\":\"г.Городской, ул.Горького, д.34\"," +
                        "\"houseElder\":{\"fullName\":\"Самый Главный Управдом\",\"dateOfBirth\":\"2000-01-20\"}," +
                        "\"flats\":[" +
                        "{\"number\":1,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}," +
                        "{\"number\":2,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}," +
                        "{\"number\":3,\"area\":150.0,\"owners\":[" +
                        "{\"fullName\":\"Иванов Иван Иванович\",\"dateOfBirth\":\"1990-12-25\"}," +
                        "{\"fullName\":\"Петров Пётр Петрович\",\"dateOfBirth\":\"1992-03-17\"}," +
                        "{\"fullName\":\"Сидоров Кирилл Анатольевич\",\"dateOfBirth\":\"2000-09-06\"}]}]}";

        try (JsonParser parser = mapper.createParser(json)) {
            JsonNode rootNode = parser.readValueAsTree();

            House house = mapper.treeToValue(rootNode, House.class);

            List<Person> owners = Arrays.asList(
                    new Person("Иванов", "Иван", "Иванович", LocalDate.parse("1990-12-25")),
                    new Person("Петров", "Пётр", "Петрович", LocalDate.parse("1992-03-17")),
                    new Person("Сидоров", "Кирилл", "Анатольевич", LocalDate.parse("2000-09-06"))
            );
            List<Flat> flats = Arrays.asList(
                    new Flat(1, 150, owners),
                    new Flat(2, 150, owners),
                    new Flat(3, 150, owners)
            );
            House houseExpected = new House("47:14:1203001:814", "г.Городской, ул.Горького, д.34",
                    new Person("Самый", "Главный", "Управдом", LocalDate.parse("2000-01-20")), flats);

            assertEquals(houseExpected, house);
        }
    }

    }