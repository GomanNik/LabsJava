import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiagMatrixTest {

    @Test
    void calculateDeterminant() {
        DiagMatrix matrix = new DiagMatrix(3);
        matrix.setElement(0,0,1);
        matrix.setElement(1,1,-2);
        matrix.setElement(2,2,3);
        assertEquals(-6,matrix.calculateDeterminant());

        double[] digElms= {1,-2};
        DiagMatrix matrix1 = new DiagMatrix(2,digElms);
        assertEquals(-2,matrix1.calculateDeterminant());
    }

    @Test
    void calculateDeterminantWithNull() {
        double[] digElms= {};
        assertThrows(IllegalArgumentException.class, () ->  new DiagMatrix(2,digElms));
    }

    @Test
    void setElement() {
        double[] digElms= {1,-2};
        DiagMatrix matrix1 = new DiagMatrix(2,digElms);
        matrix1.setElement(1,1,5);
        assertEquals(5,matrix1.getElement(1,1));


    }
    @Test
    void setElementWithNegative() {
        double[] digElms= {1,-2};
        DiagMatrix matrix1 = new DiagMatrix(2,digElms);
        assertThrows(IllegalArgumentException.class, () ->  matrix1.setElement(0,1,1));
        assertThrows(IndexOutOfBoundsException.class, () ->  matrix1.setElement(5,5,1));
    }

}