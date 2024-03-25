import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class ListDemoTest {

    @Test
    void getListWithSameLastNameTest() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Иванов","Лев","Николаевич",40);
        Student personThird = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        Student person = new Student("Иванов","Денис","Денисович",50,"Philosophy");
        List<Human> humans = Arrays.asList(personFirst,personSecond,personThird);
        List<Human> expected = Arrays.asList(personSecond,personThird);

        assertEquals(expected,ListDemo.getListWithSameLastName(humans,person));
    }
    @Test
    void getListWithSameLastNameTestWithNegative() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Student personThird = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        List<Human> humans = Arrays.asList(personFirst,personSecond,personThird);


        assertThrows(NullPointerException.class,() -> ListDemo.getListWithSameLastName(humans,null));
        assertThrows(NullPointerException.class,() -> ListDemo.getListWithSameLastName(null, new Human("Блок","Александр","Александрович",30)));
    }

    @Test
    void getOldestPeopleTest() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Student personThird = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        List<Human> humans = Arrays.asList(personFirst,personSecond,personThird);
        Set<Human> expected = new HashSet<>();
        expected.add(personSecond);

        assertEquals(ListDemo.getOldestPeople(humans),expected);
    }
    @Test
    void getOldestPeopleTestWithNegative() {
        assertThrows(NullPointerException.class,() ->ListDemo.getOldestPeople(null));
    }
}