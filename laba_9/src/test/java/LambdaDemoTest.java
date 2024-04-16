import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Function;

public class LambdaDemoTest {

    @Test
    public void testGetLength() {
        assertEquals(5, LambdaDemo.getLength.apply("Hello"));
    }

    @Test
    public void testGetFirstChar() {
        assertEquals(Character.valueOf('H'), LambdaDemo.getFirstChar.apply("Hello"));
    }

    @Test
    public void testContainsNoSpaces() {
        assertTrue(LambdaDemo.containsNoSpaces.apply("NoSpaces"));
        assertFalse(LambdaDemo.containsNoSpaces.apply("Contains Spaces"));
    }

    @Test
    public void testCountWords() {
        assertEquals(3, LambdaDemo.countWords.apply("One,Two,Three"));
    }

    @Test
    public void testGetAge() {

        Human human = new Human("John", "Doe", "Smith", 30, Gender.MALE);
        assertEquals(30, LambdaDemo.getAge.apply(human));
    }

    @Test
    public void testHasSameLastName() {
        Human human = new Human("Jane", "Doe", "Smith", 25, Gender.FEMALE);
        assertTrue(LambdaDemo.hasSameLastName.apply(human));
    }

    @Test
    public void testGetFullName() {
        Human human = new Human("Alice", "Wonderland", "", 40, Gender.FEMALE);
        assertEquals("Wonderland Alice ", LambdaDemo.getFullName.apply(human));
    }

    @Test
    public void testMakeOneYearOlder() {
        Human human = new Human("Bob", "Smith", "", 50, Gender.MALE);
        Human olderHuman = LambdaDemo.makeOneYearOlder.apply(human);
        assertEquals(human.getAge() + 1, olderHuman.getAge());
    }

    @Test
    public void testCheckIfAllYoungerThan() {
        Function<Human, Function<Human, Function<Human, Boolean>>> checkFunction = LambdaDemo.checkIfAllYoungerThan.apply(40);

        Human h1 = new Human("Alice", "Johnson", "", 35, Gender.FEMALE);
        Human h2 = new Human("John", "Smith", "", 30, Gender.MALE);
        Human h3 = new Human("Emily", "Brown", "", 45, Gender.FEMALE);

        assertTrue(checkFunction.apply(h1).apply(h2).apply(h3));
    }
}