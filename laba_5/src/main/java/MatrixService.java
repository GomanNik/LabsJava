import java.util.Arrays;

public class MatrixService {

    public static void arrangeMatrices(IMatrix[] matrices) {
        if (matrices.length != 0)
        Arrays.sort(matrices, new MatrixDeterminantComparator());
    }
}