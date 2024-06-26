import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class PersonSerializationModule extends SimpleModule {

    public PersonSerializationModule() {
        addSerializer(Person.class, new PersonSerializer());
        addDeserializer(Person.class, new PersonDeserializer());
    }

    private static class PersonSerializer extends JsonSerializer<Person> {
        @Override
        public void serialize(Person person, JsonGenerator generator, SerializerProvider provider) throws IOException {
            generator.writeStartObject();
            generator.writeStringField("fullName", person.getFirstName() + " " +
                    person.getLastName() + " " + person.getSurName());
            generator.writeStringField("dateOfBirth", person.getDateOfBirth());
            generator.writeEndObject();
        }
    }

    private static class PersonDeserializer extends JsonDeserializer<Person> {
        @Override
        public Person deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            final JsonNode tree = context.readTree(parser);
            final String[] fullName = tree.get("fullName").asText().split(" ");
            final String birthDate = tree.get("dateOfBirth").asText();

            if (fullName.length != 3) {
                throw new JsonMappingException(parser, String.format(
                        "\"fullName\" value is malformed: %s (expected size 3, but was %d)",
                        tree.get("fullName").asText(), fullName.length
                ));
            }

            return new Person(fullName[0], fullName[1], fullName[2], birthDate);
        }
    }

}
