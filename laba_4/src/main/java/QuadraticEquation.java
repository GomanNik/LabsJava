import java.util.Objects;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve()  {
        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент 'a' не может быть пустой, иначе уравнение не квадратное.");
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] {root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[] {root};
        } else {
            throw new IllegalArgumentException("Уравнение не имеет действительных корней. Дискриминант < 0");
        }
    }
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadraticEquation that = (QuadraticEquation) o;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 && Double.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" + a +
                "x + " + b +
                "x + " + c +
                " = 0}";
    }
}

