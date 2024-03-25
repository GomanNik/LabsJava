import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SinFunctionTest {
    @Test
    public void testCalculate() {
        SinFunction sinFunction = new SinFunction(1, 1, 0.0, Math.PI);
        assertEquals(1.0, sinFunction.calculate(Math.PI / 2), 0.001);

        SinFunction sinFunctionSecond = new SinFunction(1.0, 1.0, 0.0, Math.PI);
        assertEquals(0.5, sinFunctionSecond.calculate(5*Math.PI/6), 0.001);
    }

    @Test
    public void testOutOfBounds() {
        SinFunction sinFunction = new SinFunction(1.0, 2.0, 0.0, Math.PI);
        assertThrows(IllegalArgumentException.class, () -> {
            sinFunction.calculate(3 * Math.PI);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new SinFunction(1.0, 2.0, Math.PI, 0.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new SinFunction(1.0, 2.0, 0.0, 0.0);
        });
    }
}


