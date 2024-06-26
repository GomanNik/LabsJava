import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class JsonComparatorTest {

    @Test
    void compareJsonStringsTestFirst() throws IOException {
        List<Person> owners1 = Arrays.asList(
                new Person("Иванов","Иван","Иванович","1990-12-25"),
                new Person("Петров","Пётр","Петрович","1992-03-17"));
        List<Flat> flats1 = Arrays.asList(
                new Flat(1,150,owners1),
                new Flat(2,150,owners1),
                new Flat(3,150,owners1));
        House houseTest1 = new House("47:14:1203001:814","г.Городской,ул.Горького,д.34",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats1 );

        List<Person> owners2 = Arrays.asList(
                new Person("Иванов","Иван","Иванович","1990-12-25"),
                new Person("Петров","Пётр","Петрович","1992-03-17"));
        List<Flat> flats2 = Arrays.asList(
                new Flat(1,150,owners2),
                new Flat(2,150,owners2),
                new Flat(3,150,owners2));
        House houseTest2 = new House("47:14:1203001:814","г.Городской,ул.Горького,д.34",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats2 );

        String str1 = HouseSerializationUtil.serializeHouse(houseTest1);
        String str2 = HouseSerializationUtil.serializeHouse(houseTest2);

        assertTrue(JsonComparator.compareJsonStrings(str1,str2));
    }
    @Test
    void compareJsonStringsTestSecond() throws IOException{
        assertTrue(JsonComparator.compareJsonStrings("",""));
    }
    @Test
    void compareJsonStringsTestThird() throws IOException{
        List<Person> owners1 = Arrays.asList(
                new Person("Иванов","Иван","Иванович","1990-12-25"),
                new Person("Петров","Пётр","Петрович","1992-03-17"));
        List<Flat> flats1 = Arrays.asList(
                new Flat(1,150,owners1),
                new Flat(2,150,owners1),
                new Flat(3,150,owners1));
        House houseTest1 = new House("47:14:1203001:814","г.Городской,ул.Горького,д.34",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats1 );

        List<Person> owner = Arrays.asList(new Person("Владеющий","Домом","Владелец","1992-03-17"));

        List<Flat> flats = new ArrayList<>();
        flats.add(new Flat(1,45, owner));
        flats.add(new Flat(2,90, owner));

        House houseTest = new House("31:16:0123029:163","Омская обл, Омский р-он, с.Селянское, ул.Единственная,д. 2",
                new Person("Самый","Главный","Управдом","2000-01-20"),flats );

        String str =HouseSerializationUtil.serializeHouse(houseTest);
        String str1 =HouseSerializationUtil.serializeHouse(houseTest1);

        assertFalse(JsonComparator.compareJsonStrings(str1,str));
    }

}