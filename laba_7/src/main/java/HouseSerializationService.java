import java.io.*;

public class HouseSerializationService {
    public static void serializeHouse(House house, String fileName) throws IOException{
        if (house == null) throw new NullPointerException("Дом не может быть пустым");
        if (fileName.isEmpty()) throw new NullPointerException("fileName не может быть пустым");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(house);
    }
    public static House deserializeHouse(String fileName) throws IOException, ClassNotFoundException {
        if (fileName.isEmpty()) throw new NullPointerException("fileName не может быть пустым");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        return (House) ois.readObject();
    }
}