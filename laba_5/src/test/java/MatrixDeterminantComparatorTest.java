import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixDeterminantComparatorTest {

    @Test
    void compareFirst() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,1);
        matrix.setElement(0,1,2);
        matrix.setElement(1,0,3);
        matrix.setElement(1,1,4);

        double[] digElms= {1,-2};
        DiagMatrix matrix1 = new DiagMatrix(2,digElms);

        MatrixDeterminantComparator comparator = new MatrixDeterminantComparator();
        int result = comparator.compare(matrix1, matrix);
        assertEquals(0,result);
    }
    @Test
    void compareSecond() {
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(0, 2, 3);
        matrix.setElement(1, 1, 4);
        matrix.setElement(1, 2, 5);
        matrix.setElement(1, 2, 5);
        matrix.setElement(2, 2, 6);

        Matrix matrix2 = new Matrix(2);
        matrix2.setElement(0,0,1);
        matrix2.setElement(0,1,2);
        matrix2.setElement(1,0,3);
        matrix2.setElement(1,1,4);

        MatrixDeterminantComparator comparator = new MatrixDeterminantComparator();
        int result = comparator.compare(matrix2, matrix);
        assertEquals(-1,result);

    }
}