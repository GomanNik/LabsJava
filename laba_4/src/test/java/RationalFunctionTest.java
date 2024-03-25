import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RationalFunctionTest {

    @Test
    public void testCalculate() {
        RationalFunction function = new RationalFunction(1, 2, 3, 4,-5,0);

        double result1 = function.calculate(0);
        assertEquals(0.5, result1, 0.001);

        double result2 = function.calculate(-1);
        assertEquals(1, result2, 0.001);
    }

    @Test
    public void testOutOfBounds() {
        RationalFunction function = new RationalFunction(1, 2, 3, 4,-5,0);

        assertThrows(IllegalArgumentException.class, () -> {
            function.calculate(5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            function.calculate(5);
        });
    }
}