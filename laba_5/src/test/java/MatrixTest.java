import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void getDimension() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,1);
        matrix.setElement(0,1,2);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        assertEquals(2,matrix.getDimension());

    }

    @Test
    void getDeterminant() {

        Matrix matrix1 = new Matrix(2);
        matrix1.setElement(0,0,1);
        matrix1.setElement(0,1,2);
        matrix1.setElement(1,0,3);
        matrix1.setElement(1,1,4);
        matrix1.calculateDeterminant();
        assertEquals(-2,matrix1.getDeterminant());
    }
    @Test
    void getDeterminantWithSwapRow() {
        Matrix matrix = new Matrix(3);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,1);
        matrix.setElement(0,2,2);
        matrix.setElement(1,0,0);
        matrix.setElement(1,1,3);
        matrix.setElement(1,2,4);
        matrix.setElement(2,0,5);
        matrix.setElement(2,1,6);
        matrix.setElement(2,2,7);
        /* 012
        *  034
        *  567  */


        assertEquals(-10,matrix.calculateDeterminant(),0.00000001);
    }
    @Test
    void getDeterminantWithSwapRow1() {
        Matrix matrix = new Matrix(3);
        matrix.setElement(0,0,1);
        matrix.setElement(0,1,0);
        matrix.setElement(0,2,0);
        matrix.setElement(1,0,0);
        matrix.setElement(1,1,2);
        matrix.setElement(1,2,0);
        matrix.setElement(2,0,0);
        matrix.setElement(2,1,0);
        matrix.setElement(2,2,3);

        assertEquals(6,matrix.calculateDeterminant(),0.00000001);
    }
    @Test
    void getIsDeterminantCalculated() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,0);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        assertEquals(false,matrix.getIsDeterminantCalculated());

        matrix.calculateDeterminant();

        assertEquals(true,matrix.getIsDeterminantCalculated());
    }

    @Test
    void getElementWithNegative() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,0);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getElement(3,3));
    }
    @Test
    void getElement() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,0);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        assertEquals(3,matrix.getElement(1,0));
    }

    @Test
    void setElementWithNegative() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,0);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        assertThrows(IndexOutOfBoundsException.class, () -> matrix.setElement(3,3,1000));
    }

    @Test
    void setElement() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,0);
        matrix.setElement(0,1,0);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        matrix.setElement(1,1,100);
        assertEquals(100,matrix.getElement(1,1));
    }
    @Test
    void calculateDeterminant() {
        Matrix matrix = new Matrix(1);
        matrix.setElement(0,0,10.44);
        matrix.calculateDeterminant();
        assertEquals(10.44,matrix.getDeterminant());
    }
}