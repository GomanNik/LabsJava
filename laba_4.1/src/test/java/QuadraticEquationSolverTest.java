import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationSolverTest {

    @Test
    public void testSolveForLargerRoot()  {



        QuadraticEquationSolver solver = new QuadraticEquationSolver(new QuadraticEquation(1, -3, 2));
        assertEquals(2.0, solver.solveForLargerRoot());


        QuadraticEquationSolver solver1 = new QuadraticEquationSolver(new QuadraticEquation(1, -2, 1));
        assertEquals(1.0, solver1.solveForLargerRoot());


        QuadraticEquationSolver solver2 = new QuadraticEquationSolver(new QuadraticEquation(1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> solver2.solveForLargerRoot());
    }

    @Test
    public void testGetSetQuadraticEquation() {
        QuadraticEquationSolver solver = new QuadraticEquationSolver(new QuadraticEquation(1, 2, 1));
        QuadraticEquation newEquation = new QuadraticEquation(1, -3, 2);

        solver.setQuadraticEquation(newEquation);
        assertEquals(newEquation, solver.getQuadraticEquation());
    }
}