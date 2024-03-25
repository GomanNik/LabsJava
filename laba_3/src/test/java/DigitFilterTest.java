import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DigitFilterTest {

    @Test
    void testApplyWithValidDigits() {
        DigitFilter digitFilter = new DigitFilter();
        assertTrue(digitFilter.apply("12345"));
    }

    @Test
    void testApplyWithInvalidDigits() {
        DigitFilter digitFilter = new DigitFilter();
        assertFalse(digitFilter.apply("12a45"));
    }

    @Test
    void testApplyWithNullInput() {
        DigitFilter digitFilter = new DigitFilter();
        assertThrows(IllegalArgumentException.class, () -> digitFilter.apply(null));
    }

    @Test
    void testApplyWithEmptyString() {
        DigitFilter digitFilter = new DigitFilter();
        assertThrows(IllegalArgumentException.class, () -> digitFilter.apply(""));
    }
}