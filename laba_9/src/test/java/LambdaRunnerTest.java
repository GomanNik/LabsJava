import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

public class LambdaRunnerTest {

    @Test
    public void testRunLambdaWithSingleParameter() {
        Function<String, Integer> lengthFunction = s -> s.length();
        assertEquals(5, LambdaRunner.runLambda(lengthFunction, "Hello"));
    }

    @Test
    public void testRunLambdaWithTwoParameters() {
        Function<Integer, Function<Integer, Integer>> addFunction = x -> y -> x + y;
        assertEquals(5, LambdaRunner.runLambda(addFunction, 2, 3));
    }

}