import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlatSerializationModule extends SimpleModule {

    public FlatSerializationModule(ObjectMapper mapper) {
        mapper.registerModule(new PersonSerializationModule());

        addSerializer(Flat.class, new FlatSerializer(mapper));
        addDeserializer(Flat.class, new FlatDeserializer(mapper));
    }

    private static class FlatSerializer extends JsonSerializer<Flat> {
        private final ObjectMapper mapper;

        public FlatSerializer(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public void serialize(Flat flat, JsonGenerator generator, SerializerProvider provider) throws IOException {
            generator.writeStartObject();
            generator.writeNumberField("number", flat.getNumber());
            generator.writeNumberField("area", flat.getArea());

            generator.writeArrayFieldStart("owners");
            for (Person person : flat.getOwners()) {
                // Использование ObjectMapper для сериализации объекта Person
                String personJson = mapper.writeValueAsString(person);
                generator.writeRawValue(personJson);
            }
            generator.writeEndArray();

            generator.writeEndObject();
        }
    }

    private static class FlatDeserializer extends JsonDeserializer<Flat> {
        private final ObjectMapper mapper;

        public FlatDeserializer(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public Flat deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            JsonNode tree = parser.getCodec().readTree(parser);
            int number = tree.get("number").asInt();
            float area = (float) tree.get("area").asDouble();

            List<Person> owners = new ArrayList<>();
            for (JsonNode node : tree.get("owners")) {
                // Использование ObjectMapper для десериализации объекта Person
                Person person = mapper.treeToValue(node, Person.class);
                owners.add(person);
            }

            return new Flat(number, area, owners);
        }
    }
}