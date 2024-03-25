import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UpTriangleMatrixTest {

    @Test
    void setElement() {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(0, 2, 3);
        matrix.setElement(1, 1, 4);
        matrix.setElement(1, 2, 5);
        matrix.setElement(1, 2, 5);
        matrix.setElement(2, 2, 6);
        assertEquals(5,matrix.getElement(1,2));
    }
    @Test
    void setElementWithNegative() {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(0, 2, 3);
        matrix.setElement(1, 1, 4);
        matrix.setElement(1, 2, 5);
        matrix.setElement(1, 2, 5);
        matrix.setElement(2, 2, 6);
        assertThrows(IllegalArgumentException.class, () -> matrix.setElement(2,0,2));

    }
    @Test
    void calculateDeterminant() {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(0, 2, 3);
        matrix.setElement(1, 1, 4);
        matrix.setElement(1, 2, 5);
        matrix.setElement(1, 2, 5);
        matrix.setElement(2, 2, 6);

        assertEquals(24,matrix.calculateDeterminant());
    }
}