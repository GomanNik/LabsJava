import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExponentialFunctionTest {

    @Test
    public void testCalculate() {
        ExponentialFunction function = new ExponentialFunction(2, 3,-100,100);
        ExponentialFunction function1 = new ExponentialFunction(Math.exp(1), 3,-100,100);

        double result1 = function.calculate(0);
        assertEquals(5.0, result1, 0.001);

        double result2 = function1.calculate(-1);
        assertEquals(4, result2, 0.001);
    }

    @Test
    public void testNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ExponentialFunction(2, 3,1,-4);
        });

        ExponentialFunction function = new ExponentialFunction(2, 3,1,5);

        assertThrows(IllegalArgumentException.class, () -> {
            function.calculate(0);
        });
    }
}