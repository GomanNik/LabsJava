import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
    public static void saveHouseToFile(House house) {
        String filename = "house_" + house.getCadastralNumber() + ".csv";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Данные о доме\n");
            writer.write("Кадастровый номер: " + house.getCadastralNumber() + "\n");
            writer.write("Адрес: " + house.getAddress() + "\n");
            writer.write("Старший по дому: " + house.getElder().getFullName() + "\n");

            writer.write("Данные о квартирах\n");
            writer.write("№;Площадь,кв.м;Владельцы\n");

            List<Flat> flats = house.getFlats();
            for (int i = 0; i < flats.size(); i++) {
                Flat flat = flats.get(i);
                writer.write((i + 1) + ";" + flat.getArea() + ";");

                List<Person> owners = flat.getOwners();
                for (int j = 0; j < owners.size(); j++) {
                    writer.write(owners.get(j).getFio());
                    if (j < owners.size() - 1) {
                        writer.write(", ");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

}