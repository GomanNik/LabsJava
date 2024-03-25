import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    @Test
    void constructorTest() {
        Human human = new Human("Пушкин", "Александр", "Сергеевич", 38);
        assertEquals("Пушкин", human.getLastName());
        assertEquals("Александр", human.getFirstName());
        assertEquals("Сергеевич", human.getSurname());
        assertEquals(38, human.getAge());
    }

    @Test
    void constructorTestWithNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Human("", "Александр", "Сергеевич", 38));

        assertThrows(IllegalArgumentException.class, () -> new Human("Пушкин", "", "Сергеевич", 38));

        assertThrows(IllegalArgumentException.class, () -> new Human("Пушкин", "Александр", "", 38));

        assertThrows(IllegalArgumentException.class, () -> new Human("Пушкин", "Александр", "Сергеевич", -1));
    }

    @Test
    void settersTest() {
        Human human = new Human("Пушкин", "Александр", "Сергеевич", 38);
        human.setLastName("Достоевский");
        assertEquals("Достоевский", human.getLastName());
        human.setFirstName("Фёдор");
        assertEquals("Фёдор", human.getFirstName());
        human.setSurname("Михайлович");
        assertEquals("Михайлович", human.getSurname());
        human.setAge(30);
        assertEquals(30, human.getAge());
    }

    @Test
    void settersTestWithNegative() {
        Human human = new Human("Пушкин", "Александр", "Сергеевич", 38);
        assertThrows(IllegalArgumentException.class, () -> human.setLastName(""));

        assertThrows(IllegalArgumentException.class, () -> human.setFirstName(""));

        assertThrows(IllegalArgumentException.class, () -> human.setSurname(""));

        assertThrows(IllegalArgumentException.class, () -> human.setAge(-1));

        assertThrows(IllegalArgumentException.class, () -> human.setAge(200));
    }
}