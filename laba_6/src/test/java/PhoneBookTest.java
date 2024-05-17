import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @Test
    public void testAddPhone() {
        PhoneBook phoneBook = new PhoneBook();
        Human person = new Human("Пушкин","Александр","Сергеевич",38);
        phoneBook.addPhone(person, "1234567890");

        Student student = new Student("Студентов", "Студент", "Студентович", 20, "Faculty");
        phoneBook.addPhone(student, "9876543210");

        List<String> expected = Arrays.asList("9876543210","1234567890");


        assertEquals(expected,phoneBook.getAllPhones());
    }

    @Test
    public void testRemovePhone() {
        PhoneBook phoneBook = new PhoneBook();
        Human person = new Human("Толстой","Лев","Николаевич",40);

        phoneBook.addPhone(person, "9876543210");
        phoneBook.removePhone(person, "9876543210");

        List<String> phones = phoneBook.getPhones(person);
        assertFalse(phones.contains("9876543210"));
    }

    @Test
    public void testFindPersonByPhoneNumber() {
        PhoneBook phoneBook = new PhoneBook();
        Human person = new Human("Евгеньева", "Евгения", "Евгеньевна", 29);

        phoneBook.addPhone(person, "111222333");

        Human foundPerson = phoneBook.findPersonByPhoneNumber("111222333");
        assertEquals(person, foundPerson);
    }

    @Test
    public void testFindPeopleByLastName() {
        PhoneBook phoneBook = new PhoneBook();

        Human person1 = new Human("Иванова", "Алиса", "Ивановна", 30);
        Human person2 = new Human("Петров", "Петр", "Петрович", 45);
        Student student = new Student("Иванов", "Иван", "Иванович", 20, "Faculty");
        phoneBook.addPhone(person1, "444555666");
        phoneBook.addPhone(person2, "777888999");
        phoneBook.addPhone(student, "111111111");

        Map<Human, List<String>> result = phoneBook.findPeopleByLastName("И");
        assertTrue(result.containsKey(person1));
        assertFalse(result.containsKey(person2));
        assertTrue(result.containsKey(student));
    }
}