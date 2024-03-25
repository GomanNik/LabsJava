public class DiagMatrix extends Matrix  {

    public DiagMatrix(int dimension) {
        super(dimension);
    }

    public DiagMatrix(int dimension, double[] diagonalElements) {
        super(dimension);
        if (diagonalElements.length != dimension) {
            throw new IllegalArgumentException("Количество элементов на диагонали должно быть равно размерности матрицы");
        }
        for (int i = 0; i < dimension; i++) {
            setElement(i, i, diagonalElements[i]);
        }
    }

    @Override
    public double calculateDeterminant() {
        int size = getDimension();

        if (!getIsDeterminantCalculated()) {
            double det = 1;
            for (int i = 0; i < size; i++) {
                det *= getElement(i, i);
            }
            setDeterminant(det);
            setIsDeterminantCalculated(true);
        }
        return getDeterminant();
    }

    @Override
    public void setElement(int row, int column, double value) {
        if (row != column) {
            throw new IllegalArgumentException("Невозможно установить ненулевое значение вне диагонали");
        }
        if (row < 0 || row >= getDimension()) {
            throw new IndexOutOfBoundsException("Неверные индексы элемента матрицы");
        }
        super.setElement(row, column, value);
        setIsDeterminantCalculated(false);
    }
    @Override
    public void print(){
        printMatrix();
        System.out.print("getDeterminant for matrix = ");
        System.out.printf("%.2f",calculateDeterminant());
        System.out.println();
        System.out.println();
    }
}