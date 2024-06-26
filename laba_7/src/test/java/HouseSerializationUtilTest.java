import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseSerializationUtilTest {

    @Test
    void serializeHouseTestFirst() throws IOException,ClassNotFoundException {
        List<Person> owners = Arrays.asList(
                new Person("Иванов","Иван","Иванович","1990-12-25"),
                new Person("Петров","Пётр","Петрович","1992-03-17")
        );
        List<Flat> flats = Arrays.asList(
                new Flat(1,150,owners),
                new Flat(2,150,owners),
                new Flat(3,150,owners)
        );

        House houseTest = new House("47:14:1203001:814","г.Городской,ул.Горького,д.34",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats );
        String serializedHouse  = HouseSerializationUtil.serializeHouse(houseTest);
        House deserializedHouse = HouseSerializationUtil.deserializeHouse(serializedHouse );
        assertEquals(houseTest,deserializedHouse);
    }
    @Test
    void serializeHouseTestSecond() throws IOException,ClassNotFoundException {
        List<Person> owner = Arrays.asList(new Person("Владеющий","Домом","Владелец","1992-03-17"));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1,45, owner));
        flats.add(new Flat(2,90, owner));

        House houseTest = new House("31:16:0123029:163","Омская обл, Омский р-он, с.Селянское, ул.Единственная,д. 2",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats );

        String serializedHouse  = HouseSerializationUtil.serializeHouse(houseTest);
        House deserializedHouse = HouseSerializationUtil.deserializeHouse(serializedHouse);
        assertEquals(houseTest,deserializedHouse);
    }
    @Test
    void serializeHouseWithNegativeTest(){
        assertThrows(NullPointerException.class,()-> HouseSerializationUtil.serializeHouse(null));

        assertThrows(NullPointerException.class,()-> HouseSerializationUtil.serializeHouse(null));
    }

    @Test
    void deserializeHouseWithNegativeTest()  {
        assertThrows(NullPointerException.class,()-> HouseSerializationUtil.deserializeHouse(null));
    }
    @Test
    void saveHouseToFileTest(){
        List<Person> owner = Arrays.asList(new Person("Владеющий","Домом","Владелец","1992-03-17"),
                new Person("Владеющий2","Домом2","Владелец2","1992-03-17"));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1,45, owner));
        flats.add(new Flat(2,90, owner));

        House houseTest = new House("31.1.1.3","Омская обл, Омский р-он, с.Селянское, ул.Единственная,д. 2",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats );
        HouseSerializationUtil.saveHouseToFile(houseTest);
    }
}