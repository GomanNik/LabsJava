import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void constructorTest() {
        Student student = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        assertEquals("Иванов", student.getLastName());

        assertEquals("Иван", student.getFirstName());

        assertEquals("Иванович", student.getSurname());

        assertEquals(22, student.getAge());

        assertEquals("Computer Science", student.getFaculty());
    }

    @Test
    void constructorTestWithNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Student("","Иван","Иванович",22,"Computer Science"));

        assertThrows(IllegalArgumentException.class, () -> new Student("Иванов","","Иванович",22,"Computer Science"));

        assertThrows(IllegalArgumentException.class, () -> new Student("Иванов","Иван","",22,"Computer Science"));

        assertThrows(IllegalArgumentException.class, () -> new Student("Иванов","Иван","Иванович",-3,"Computer Science"));

        assertThrows(IllegalArgumentException.class, () -> new Student("Иванов","Иван","Иванович",22,""));
    }

    @Test
    void setFacultyTest() {
        Student student = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        student.setFaculty("Mathematics");

        assertEquals("Mathematics", student.getFaculty());
    }

    @Test
    void setFacultyTestWithNegative() {
        Student student = new Student("Иванов","Иван","Иванович",22,"Computer Science");

        assertThrows(IllegalArgumentException.class, () -> student.setFaculty(""));
    }
}