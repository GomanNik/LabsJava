public class RectangleIntegration<T extends RealFunction> implements Functional<T> {

    private double lowerBound;
    private double upperBound;

    public RectangleIntegration(double lowerBound, double upperBound) {
        if(Double.valueOf(upperBound).equals(lowerBound) || lowerBound>upperBound )
            throw new IllegalArgumentException("Недопустимые  границы");
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(T function) {
        if (lowerBound < function.getLowerBound() || function.getUpperBound() > upperBound) {
            throw new IllegalArgumentException("Область определения функции не содержится в [a; b]");
        }

        double step = 0.0001;
        double integral = 0.0;

        for (double x = lowerBound; x < upperBound; x += step) {
            integral += function.calculate(x) * step;
        }

        return integral;
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