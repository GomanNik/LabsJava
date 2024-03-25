import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearFunctionTest {
    @Test
    public void testCalculate() {
        LinearFunction linearFunction1 = new LinearFunction(2.0, 3.0, 0.0, 10.0);
        LinearFunction linearFunction2 = new LinearFunction(0.0, 15.0, 0.0, 1.0);

        assertEquals(13.0, linearFunction1.calculate(5.0));
        assertEquals(15, linearFunction2.calculate(0.5));
    }

    @Test
    public void testOutOfBounds() {
        LinearFunction linearFunction = new LinearFunction(2.0, 3.0, 0.0, 10.0);
        assertThrows(IllegalArgumentException.class,() ->{
            new LinearFunction(2.0, 3.0, 10,0);

        });
        assertThrows(IllegalArgumentException.class,() ->{
            new LinearFunction(2.0, 3.0, 0,0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            linearFunction.calculate(20.0);
        });
    }
}