import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FunctionSumTest {

    @Test
    public void testFunctionSumWithValidBounds() {
        SinFunction sinFunction = new SinFunction(1, 1, 0.0, Math.PI);
        FunctionSum<RealFunction> sinFunctionSum = new FunctionSum<>(0, Math.PI);

        LinearFunction linearFunction = new LinearFunction(1,3,0,10);
        FunctionSum<RealFunction> linFunctionSum = new FunctionSum<>(0, 10);
        // x+3 на промежутке (0,10) => при f(0)=3,f(5)=8,f(10)=13 сумма равна 24

        RationalFunction rationalFunction = new RationalFunction(0,1,4,5,-1,1);
        FunctionSum<RealFunction> ratFunctionSum = new FunctionSum<>(-1, 1);
        // (0*x+1)/4x+5 на отрезке от (-1,1) => f(-1)=1,f(0)=1\5,f(1)=1\9 сумма равна 59/45~1.31111

        ExponentialFunction exponentialFunction = new ExponentialFunction(3,3,-3,3);
        FunctionSum<RealFunction> expFunction = new FunctionSum<>(0, 3);
        // 3*exp(x)+3 на отрезке от (0,3) => f(0)=6,f(1.5)=16.44507,f(3)=63.25661 сумма равна 85.70168

        assertEquals(0.0 + 1.0 + 0.0, sinFunctionSum.calculate(sinFunction), 0.001);
        assertEquals(24, linFunctionSum.calculate(linearFunction), 0.001);
        assertEquals(1.3111, ratFunctionSum.calculate(rationalFunction), 0.001);
        assertEquals(85.70168, expFunction.calculate(exponentialFunction), 0.001);
    }

    @Test
    public void testFunctionSumWithInvalidBounds() {
        SinFunction sinFunction = new SinFunction(1, 1, 0, Math.PI / 2 );
        FunctionSum<RealFunction> functionSum = new FunctionSum<>(-1*Math.PI, Math.PI);

        assertThrows(IllegalArgumentException.class, () -> {
            functionSum.calculate(sinFunction);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new FunctionSum<>(Math.PI, Math.PI / 2);
        });
    }
}
