import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class HouseSerializationUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String serializeHouse(House house)throws IOException {
        if (house==null) throw new NullPointerException("Необходим не пустой дом");
        return objectMapper.writeValueAsString(house);
    }

    public static House deserializeHouse(String json)throws IOException  {
        if (json.isEmpty()) throw new NullPointerException("json не может быть пустым");
        return objectMapper.readValue(json, House.class);
    }
}