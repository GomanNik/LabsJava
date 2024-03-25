import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleIntegrationTest {
    //все коментарии проверил на фотомач
    @Test
    public void testRectangleIntegrationWithValidBounds() {
        SinFunction sinFunction = new SinFunction(1, 1, 0.0, Math.PI);
        RectangleIntegration<RealFunction> sinFunctionSum = new RectangleIntegration<>(0, Math.PI);
        // -cos(X) |(0,Pi) = -cos(PI)-(-cos(0))= 1+1 = 2

        LinearFunction linearFunction = new LinearFunction(1,3,0,10);
        RectangleIntegration<RealFunction> linFunctionSum = new RectangleIntegration<>(0, 10);
        // x+3 на промежутке (0,10) => ((x^2)/2 + 3*x)|(0,10) = 80

        RationalFunction rationalFunction = new RationalFunction(0,1,4,5,-1,1);
        RectangleIntegration<RealFunction> ratFunctionSum = new RectangleIntegration<>(-1, 1);
        // (0*x+1)/4x+5 на отрезке от (-1,1) => ln|4x+5|/4  |(-1,1) ~= 0,549306

        ExponentialFunction exponentialFunction = new ExponentialFunction(3,3,-3,3);
        RectangleIntegration<RealFunction> expFunction = new RectangleIntegration<>(0, 3);
        // 3*exp(x)+3 на отрезке от (0,3) => (3*e^x+3x)|(0,3) ~=66,25661;

        assertEquals(2, sinFunctionSum.calculate(sinFunction), 0.01);
        assertEquals(80, linFunctionSum.calculate(linearFunction), 0.01);
        assertEquals(0.549306, ratFunctionSum.calculate(rationalFunction), 0.01);
        assertEquals(66.25661, expFunction.calculate(exponentialFunction), 0.01);
    }

    @Test
    public void testRectangleIntegrationWithInvalidBounds() {
        LinearFunction linearFunction = new LinearFunction(0.0, 15.0, 0.0, 1.0);
        RectangleIntegration<RealFunction> integration = new RectangleIntegration<>(0, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            integration.calculate(linearFunction);
        });
    }
}