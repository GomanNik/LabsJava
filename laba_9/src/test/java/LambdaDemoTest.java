import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {


    @Test
    public void testGetLength() {
        assertEquals(5, LambdaRunner.runFunction(LambdaDemo.getLength,"Hello"));
    }
    @Test
    public void testGetLength_negative() {
        assertNotEquals(4, LambdaRunner.runFunction(LambdaDemo.getLength, "Test String"));
    }
    @Test
    public void testGetFirstChar() {
        assertEquals('H', LambdaRunner.runFunction(LambdaDemo.getFirstChar,"Hello"));
    }
    @Test
    public void testGetFirstChar_negative() {
        assertNotEquals('A', LambdaRunner.runFunction(LambdaDemo.getFirstChar, "Hello"));
    }
    @Test
    public void testContainsNoSpaces() {
        assertTrue(LambdaRunner.runPredicate(LambdaDemo.containsNoSpaces,"NoSpaces"));
    }
    @Test
    public void testContainsNoSpaces_negative() {
        assertFalse(LambdaRunner.runPredicate(LambdaDemo.containsNoSpaces,"Contains Spaces"));
    }

    @Test
    public void testCountWords() {
        assertEquals(3, LambdaRunner.runFunction(LambdaDemo.countWords,"1,2,3"));

        assertEquals(2, LambdaRunner.runFunction(LambdaDemo.countWords,"OneWord,  SecondWord"));
    }
    @Test
    public void testCountWords_negative() {
        assertNotEquals(5, LambdaRunner.runFunction(LambdaDemo.countWords,"1,2,3"));
    }

    @Test
    public void testGetAge() {
        Human human = new Human("John", "Doe", "Smith", 30, Gender.MALE);
        assertEquals(30,LambdaRunner.runFunction(LambdaDemo.getAge,human));
    }
    @Test
    public void testGetAge_negative() {
        Human human = new Human("Виктор", "Пелевин", "Олегович", 61, Gender.MALE);
        assertNotEquals(30,LambdaRunner.runFunction(LambdaDemo.getAge,human));
    }

    @Test
    public void testHasSameLastName() {
        Human humanFirst = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);
        Human humanSecond = new Human("Иванов", "Петр", "Иванович", 13, Gender.MALE);

        assertTrue(LambdaRunner.runBiPredicate(LambdaDemo.checkSameLastName,humanFirst,humanSecond));
    }

    @Test
    public void testHasSameLastName_negative() {
        Human humanFirst = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);
        Human humanSecond = new Human("Смирнова", "Алина", "Михайловна", 20, Gender.FEMALE);

        assertFalse(LambdaRunner.runBiPredicate(LambdaDemo.checkSameLastName,humanFirst,humanSecond));
    }

    @Test
    public void testFirstGetFullName() {
        Human human = new Human("Вундерланд", "Алина", "", 20, Gender.FEMALE);

        assertEquals("Вундерланд Алина ",LambdaRunner.runFunction(LambdaDemo.getFullName,human));
    }
    @Test
    public void testSecondGetFullName() {
        Human humanFirst = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);

        assertEquals("Иванов Иван Иванович",LambdaRunner.runFunction(LambdaDemo.getFullName,humanFirst));
    }

    @Test
    public void testFirstMakeOneYearOlder() {
        Human human = new Human("Bob", "Smith", "", 50, Gender.MALE);

        assertEquals(51,LambdaRunner.runUnaryOperator(LambdaDemo.makeOneYearOlder,human).getAge());
    }

    @Test
    public void testSecondMakeOneYearOlder() {
        Human humanFirst = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);

        assertEquals(16,LambdaRunner.runUnaryOperator(LambdaDemo.makeOneYearOlder,humanFirst).getAge());
    }

    @Test
    public void testCheckIfAllYoungerThan() {
        Human[] humans = new Human[3];
        humans[0] = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);
        humans[1] = new Human("Смирнова", "Алина", "Михайловна", 20, Gender.FEMALE);
        humans[2] = new Human("Виктор", "Пелевин", "Олегович", 30, Gender.MALE);
        assertTrue(LambdaRunner.runBiPredicate(LambdaDemo.checkIfAllYoungerThan,40,humans));
    }
    @Test
    public void testCheckIfAllYoungerThan_negative() {
        Human[] humans = new Human[2];
        humans[0] = new Human("Иванов","Иван","Иванович", 15, Gender.MALE);
        humans[1] = new Human("Смирнова", "Алина", "Михайловна", 20, Gender.FEMALE);
        assertFalse(LambdaRunner.runBiPredicate(LambdaDemo.checkIfAllYoungerThan,40,humans));
    }
}