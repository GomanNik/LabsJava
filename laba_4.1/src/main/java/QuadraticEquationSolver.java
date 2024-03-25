import java.util.Objects;

public class QuadraticEquationSolver {
    private QuadraticEquation quadraticEquation;

    public QuadraticEquationSolver(QuadraticEquation quadraticEquation) {
        if( quadraticEquation == null)
            throw new IllegalArgumentException("quadraticEquation не существует");
        this.quadraticEquation = quadraticEquation;
    }

    public double solveForLargerRoot() {
        double[] roots = quadraticEquation.solve();
        if (roots.length == 1) {
            return roots[0];
        } else if (roots.length == 2) {
            return Math.max(roots[0], roots[1]);
        } else {
            throw new IllegalArgumentException("Уравнение не имеет действительных корней");
        }
    }

    public QuadraticEquation getQuadraticEquation() {
        return quadraticEquation;
    }

    public void setQuadraticEquation(QuadraticEquation quadraticEquation) {
        this.quadraticEquation = quadraticEquation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadraticEquationSolver that = (QuadraticEquationSolver) o;
        return Objects.equals(quadraticEquation, that.quadraticEquation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quadraticEquation);
    }

    @Override
    public String toString() {
        return "QuadraticEquationSolver{" +
                "quadraticEquation=" + quadraticEquation +
                '}';
    }
}