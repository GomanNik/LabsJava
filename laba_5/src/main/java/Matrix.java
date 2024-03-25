import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int dimension;
    private double[] elements;
    private boolean isDeterminantCalculated = false;
    private double determinant=1;


    public Matrix(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность матрицы должна быть положительным числом");
        }

        this.dimension = dimension;
        this.elements = new double[dimension * dimension];
    }

    public int getDimension() {
        return dimension;
    }
    public void setDeterminant(double det){
        this.determinant = det;
    }

    public double getDeterminant() {
        return determinant;
    }

    public boolean getIsDeterminantCalculated() {
        return isDeterminantCalculated;
    }
    public void setIsDeterminantCalculated(boolean flag) {
        isDeterminantCalculated=flag;
    }

    @Override
    public double getElement(int row, int column) {
        if (row < 0 || row >= dimension || column < 0 || column >= dimension) {
            throw new IndexOutOfBoundsException("Неверные индексы элемента матрицы");
        }
        return elements[row * dimension + column];
    }

    @Override
    public void setElement(int row, int column, double value) {
        if (row < 0 || row >= dimension || column < 0 || column >= dimension) {
            throw new IndexOutOfBoundsException("Неверные индексы элемента матрицы");
        }
        elements[row * dimension + column] = value;
        isDeterminantCalculated = false;
    }

    @Override
    public double calculateDeterminant() {
        if (dimension == 0) {
            throw new IllegalArgumentException("Матрица пустая");
        }
        if (!isDeterminantCalculated) {

            Matrix matrixCopy = new Matrix(dimension);
            double det = 1;
            int swapRow;

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++)
                    matrixCopy.setElement(i, j, getElement(i, j));
            }

            for (int i = 0; i < dimension - 1; i++) {
                if (matrixCopy.getElement(i, i) == 0) {
                    swapRow=-1;
                    for (int j = i + 1; j < dimension; j++) {
                        if (matrixCopy.getElement(j, i) != 0) {
                            swapRow = j;
                            break;
                        }
                    }
                    if (swapRow == -1) {
                        return 0;
                    }

                    swapRows(i, swapRow, matrixCopy);
                    det *= -1;
                }
                for (int j = i + 1; j < dimension; j++) {
                    double ratio = matrixCopy.getElement(j, i) / matrixCopy.getElement(i, i);
                    for (int k = i; k < dimension; k++) {
                        matrixCopy.setElement(j, k, matrixCopy.getElement(j, k) - ratio * matrixCopy.getElement(i, k));
                    }
                }
            }

            for (int i = 0; i < dimension; i++) {
                det *= matrixCopy.getElement(i, i);
                if (det == -0) det *= -1;
            }
            determinant = det;
            isDeterminantCalculated = true;
            return determinant;
        }
        return determinant;
    }

    private void swapRows(int row1, int row2, Matrix matrixCopy) {

        double[] row = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            row[i] = matrixCopy.getElement(row1, i);
        }
        for (int i = 0; i < dimension; i++) {
            matrixCopy.setElement(row1, i, matrixCopy.getElement(row2, i));
        }
        for (int i = 0; i < dimension; i++) {
            matrixCopy.setElement(row2, i, row[i]);
        }
    }
    public void printMatrix(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.printf("%.2f\t", getElement(i, j));
            }
            System.out.println();
        }
    }
    public void print(){
        printMatrix();
        System.out.print("getDeterminant for matrix = ");
        System.out.printf("%.2f",calculateDeterminant());
        System.out.println();
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix other = (Matrix) o;
        if (dimension != other.dimension) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != other.elements[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}