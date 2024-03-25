import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeginStringFilterTest{
    @Test
    public void testApply() {
        BeginStringFilter testFirst = new BeginStringFilter("Мама");
        BeginStringFilter testSecond = new BeginStringFilter("мыла");
        BeginStringFilter testThird= new BeginStringFilter("Мама мыла");

        assertTrue(testFirst.apply("Мама мыла раму"));
        assertFalse(testSecond.apply("Мама мыла раму"));
        assertTrue(testThird.apply(("Мама мыла раму")));
        assertFalse(testThird.apply(("Мама раму")));
    }
    @Test
    public void testGetPattern(){
        BeginStringFilter testFirst = new BeginStringFilter("Мама");
        String testString = "Мама";

        assertEquals(testString,testFirst.getPattern());
    }

    @Test
    public void testSetPattern(){
        BeginStringFilter testFirst = new BeginStringFilter("Мама");
        testFirst.setPattern("Папа");

        assertEquals("Папа",testFirst.getPattern());
    }

    @Test
    public void testSetPatternWithNegative(){
        BeginStringFilter testFirst = new BeginStringFilter("Мама");

        assertThrows(NullPointerException.class, () -> testFirst.setPattern(null));
    }
}