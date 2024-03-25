import java.util.Comparator;

public class MatrixDeterminantComparator implements Comparator<IMatrix> {
    public int compare(IMatrix matrix1, IMatrix matrix2) {
        return Double.compare(matrix1.calculateDeterminant(), matrix2.calculateDeterminant());
    }
}