import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.List;

public class HouseSerializationModule extends SimpleModule {

    public HouseSerializationModule(ObjectMapper mapper) {
        // Регистрация FlatSerializationModule и PersonSerializationModule
        mapper.registerModule(new FlatSerializationModule(mapper));

        addSerializer(House.class, new HouseSerializer(mapper));
        addDeserializer(House.class, new HouseDeserializer(mapper));

    }

    private static class HouseSerializer extends JsonSerializer<House> {
        private final ObjectMapper mapper;

        public HouseSerializer(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public void serialize(House house, JsonGenerator generator, SerializerProvider provider) throws IOException {
            generator.writeStartObject();

            generator.writeStringField("cadastralId", house.getCadastralNumber());
            generator.writeStringField("address", house.getAddress());
            generator.writeObjectField("houseElder", house.getElder());

            generator.writeArrayFieldStart("flats");
            for (Flat flat : house.getFlats()) {
                // Использование ObjectMapper для сериализации объекта Flat
                generator.writeObject(flat);
            }
            generator.writeEndArray();

            generator.writeEndObject();
        }
    }

    private static class HouseDeserializer extends JsonDeserializer<House> {
        private final ObjectMapper mapper;

        public HouseDeserializer(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public House deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            JsonNode tree = parser.getCodec().readTree(parser);
            String cadastralId = tree.get("cadastralId").asText();
            String address = tree.get("address").asText();
            Person houseElder = mapper.treeToValue(tree.get("houseElder"), Person.class);

            List<Flat> flats = mapper.readValue(tree.get("flats").traverse(), mapper.getTypeFactory().constructCollectionType(List.class, Flat.class));

            return new House(cadastralId, address, houseElder, flats);
        }
    }
}