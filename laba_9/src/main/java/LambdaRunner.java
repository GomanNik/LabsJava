import java.util.function.Function;
public class LambdaRunner {
    public static <T, R> R runLambda1(Function<T, R> function, T parameter) {
        return function.apply(parameter);
    }

    public static <T, U, R> R runLambda2(Function<T, Function<U, R>> function, T parameter1, U parameter2) {
        return function.apply(parameter1).apply(parameter2);
    }

}