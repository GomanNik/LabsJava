import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringProcessorTest {

    @Test
    public void testRepeatStringWithNegativeN() {
        assertThrows(Exception.class, () -> StringProcessor.repeatString("abc", -1));
    }

    @Test
    public void testRepeatString() {
        assertEquals("Привет Привет Привет ",StringProcessor.repeatString("Привет", 3));
    }

    @Test
    public void testCountOccurrencesWithEmptySubString() {
        assertThrows(Exception.class, () -> StringProcessor.countOccurrences("abc", ""));
    }

    @Test
    public void testCountOccurrences() {
        StringProcessor.countOccurrences("Программирование", "ро");

        assertEquals(2, StringProcessor.countOccurrences("aaa", "aa"));
        assertEquals(3, StringProcessor.countOccurrences("aaaa", "aa"));
    }

    @Test
    public void testReplaceDigitsWithWords() {
        assertEquals("один два три", StringProcessor.replaceDigitsWithWords("1 2 3"));
        assertEquals("один 5 три", StringProcessor.replaceDigitsWithWords("1 5 3"));
        assertEquals("555", StringProcessor.replaceDigitsWithWords("555"));
        assertEquals("одинодин двадва три", StringProcessor.replaceDigitsWithWords("11 22 3"));
    }

    @Test
    public void testRemoveEverySecondChar() {
        StringBuilder input = new StringBuilder("program");
        StringProcessor.removeEverySecondChar(input);
        assertEquals("rga", input.toString());
    }
}






