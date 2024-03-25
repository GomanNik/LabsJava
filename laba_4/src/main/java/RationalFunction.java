import java.util.Objects;

public class RationalFunction implements RealFunction {
    private double A;
    private double B;
    private double C;
    private double D;
    private double lowerBound;
    private double upperBound;

    public RationalFunction(double A, double B, double C, double D, double lowerBound, double upperBound) {
        if(Double.valueOf(upperBound).equals(lowerBound) || lowerBound>upperBound )
            throw new IllegalArgumentException("Недопустимые  границы");
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public double calculate(double x) throws IllegalArgumentException {
        if (x < lowerBound || x > upperBound) {
            throw new IllegalArgumentException("Входное значение находится за пределами области определения функции");
        }
        if (C * x + D == 0) {
            throw new IllegalArgumentException("Функция не определена в x = " + x + ".");
        }
        return (A * x + B) / (C * x + D);
    }

    @Override
    public double getLowerBound() {
        return lowerBound;
    }

    @Override
    public double getUpperBound() {
        return upperBound;
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

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double getD() {
        return D;
    }

    public void setD(double d) {
        D = d;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalFunction that = (RationalFunction) o;
        return Double.compare(that.A, A) == 0 && Double.compare(that.B, B) == 0 && Double.compare(that.C, C) == 0 && Double.compare(that.D, D) == 0 && Double.compare(that.lowerBound, lowerBound) == 0 && Double.compare(that.upperBound, upperBound) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C, D, lowerBound, upperBound);
    }

    @Override
    public String toString() {
        return "RationalFunction{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", D=" + D +
                ", lowerBound=" + lowerBound +
                ", upperBound=" + upperBound +
                '}';
    }
}
