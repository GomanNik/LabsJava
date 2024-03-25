import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MatrixServiceTest {

    @Test
    public void testEmptyArray() {
        Matrix[] matrices = new Matrix[0];
        MatrixService.arrangeMatrices(matrices);
        assertEquals(0, matrices.length);
    }
    @Test
    public void testSingleMatrix() {
        Matrix matrix = new Matrix(3);
        Matrix[] matrices = {matrix};
        MatrixService.arrangeMatrices(matrices);
        assertEquals(1, matrices.length);
        assertEquals(matrix, matrices[0]);
    }
    @Test
    public void testMultipleMatricesWithDifferentDeterminants() {
        IMatrix matrix1 = new DiagMatrix(3);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(1, 1, 2);
        matrix1.setElement(2, 2, 3);
        // определитель matrix1 = 6

        IMatrix matrix2 = new Matrix(2);
        matrix2.setElement(0, 0, 0);
        matrix2.setElement(0, 1, 0);
        matrix2.setElement(1, 0, 0);
        matrix2.setElement(1, 1, 0);
        // определитель matrix2 = 0

        IMatrix matrix3 = new UpTriangleMatrix(3);
        matrix3.setElement(0, 0, 1);
        matrix3.setElement(0, 1, 2);
        matrix3.setElement(0, 2, 3);
        matrix3.setElement(1, 1, 4);
        matrix3.setElement(1, 2, 5);
        matrix3.setElement(2, 2, 6);

        // определитель matrix3 = 24

        IMatrix[] matrices = {matrix3,matrix2,matrix1};
        IMatrix[] matricesTest = {matrix2,matrix1,matrix3};
        //                      24      0      6
        MatrixService.arrangeMatrices(matrices);

        assertEquals(matrix2, matrices[0]);//  0
        assertEquals(matrix1, matrices[1]);//  6
        assertEquals(matrix3, matrices[2]);//  24
        assertArrayEquals(matricesTest,matrices);
    }
    @Test
    public void MatricesTest1(){
        Matrix matrix1 = new Matrix(4);
        double elem;
        int dim = matrix1.getDimension();
        for (int i=0; i < dim; i++ ){
            for (int j=0; j < dim; j++ ){
                elem = Math.round(-30+Math.random()*100)/10.0;
                matrix1.setElement(i,j,elem);
            }
        }
        double[] digElms = new double[4];
        for (int i=0; i < 4; i++ ){
            for (int j=0; j < 4; j++ ){
                elem = Math.round(-30+Math.random()*100)/10.0;
                digElms[i] = elem;
            }
        }
        DiagMatrix matrix2 = new DiagMatrix(4,digElms);

        UpTriangleMatrix matrix3 = new UpTriangleMatrix(5);

        for (int i=0; i < 5; i++ ){
            for (int j=i; j < 5; j++ ){
                elem = Math.round(-30+Math.random()*100)/10.0;
                matrix3.setElement(i,j,elem);
            }
        }

        Matrix[] matrices = new Matrix[]{matrix1,matrix2,matrix3};
        MatrixService.arrangeMatrices(matrices);

        Map<Double, Matrix> matricesTest = new TreeMap<>();
        matricesTest.put(matrix1.calculateDeterminant(),matrix1);
        matricesTest.put(matrix2.calculateDeterminant(),matrix2);
        matricesTest.put(matrix3.calculateDeterminant(),matrix3);

        int i=0;
        for (Matrix entry: matricesTest.values()){
            assertEquals(entry,matrices[i]);
            i++;
        }

    }
}