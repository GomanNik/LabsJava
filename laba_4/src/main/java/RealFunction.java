public interface RealFunction {
    double calculate(double x);

    double getLowerBound();

    double getUpperBound();
}