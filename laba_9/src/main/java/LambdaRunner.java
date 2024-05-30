import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {
    public static <T, R> R runFunction(Function<T, R> function, T parameter) {
        return function.apply(parameter);
    }
    public static <T> boolean runPredicate(Predicate<T> predicate, T parameter) {
        return predicate.test(parameter);
    }
    public static <T,U> boolean runBiPredicate(BiPredicate<T,U> biPredicate,T parameter1, U parameter2) {
        return biPredicate.test(parameter1,parameter2);
    }
    public static <T> T  runUnaryOperator(UnaryOperator<T> operator, T parameter) {
        return operator.apply(parameter);
    }

}