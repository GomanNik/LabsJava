public class FunctionSum<T extends RealFunction> implements Functional<T> {
    private double lowerBound;
    private double upperBound;

    public FunctionSum(double lowerBound, double upperBound) {
        if(Double.valueOf(upperBound).equals(lowerBound) || lowerBound>upperBound )
            throw new IllegalArgumentException("Недопустимые  границы");
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(T function) {
        double startValue = function.calculate(lowerBound);
        double endValue = function.calculate(upperBound);
        double midValue = function.calculate((lowerBound + upperBound) / 2);
        return startValue + endValue + midValue;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }
}