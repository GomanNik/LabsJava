import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class QuadraticEquationTest {
    @Test
    void testSolve() {

        QuadraticEquation equation1 = new QuadraticEquation(1, -3, 2);
        QuadraticEquation equation2 = new QuadraticEquation(2, -4, 2);
        QuadraticEquation equation3 = new QuadraticEquation(1, -2, 1);
        QuadraticEquation equation4 = new QuadraticEquation(1, 1, 1);


        assertArrayEquals(new double[] {2,1}, equation1.solve(), 1e-6);
        assertArrayEquals(new double[] {1}, equation2.solve(), 1e-6);
        assertArrayEquals(new double[] {1}, equation3.solve(), 1e-6);
        assertThrows(IllegalArgumentException.class, equation4::solve);
    }
    @Test
    public void testToString() {
        QuadraticEquation equation1 = new QuadraticEquation(1, -3, 2);
        String testString = "QuadraticEquation{1.0x + -3.0x + 2.0 = 0}";
        assertEquals(testString,equation1.toString());
    }
}