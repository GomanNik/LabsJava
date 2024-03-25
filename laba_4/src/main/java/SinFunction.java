import java.util.Objects;

public class SinFunction implements RealFunction {
    private double A;
    private double B;
    private double lowerBound;
    private double upperBound;

    public SinFunction(double A, double B, double lowerBound, double upperBound) {
        if(Double.valueOf(upperBound).equals(lowerBound) || lowerBound>upperBound )
            throw new IllegalArgumentException("Недопустимые  границы");

        this.A = A;
        this.B = B;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(double x) throws IllegalArgumentException {
        if (x < lowerBound || x > upperBound) {
            throw new IllegalArgumentException("Входное значение находится за пределами области определения функции.");
        }
        return A * Math.sin(B * x);
    }

    @Override
    public double getLowerBound() {
        return lowerBound;
    }
    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinFunction that = (SinFunction) o;
        return Double.compare(that.A, A) == 0 && Double.compare(that.B, B) == 0 && Double.compare(that.lowerBound, lowerBound) == 0 && Double.compare(that.upperBound, upperBound) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, lowerBound, upperBound);
    }

    @Override
    public String toString() {
        return "SinFunction{" +
                "A=" + A +
                ", B=" + B +
                ", lowerBound=" + lowerBound +
                ", upperBound=" + upperBound +
                '}';
    }
}