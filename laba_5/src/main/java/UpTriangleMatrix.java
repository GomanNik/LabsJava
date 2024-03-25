public class UpTriangleMatrix extends Matrix{

    public UpTriangleMatrix(int dimension) {
        super(dimension);
    }
    @Override
    public void setElement(int row, int column, double value) {
        if (row > column) {
            throw new IllegalArgumentException("Можно установить только значения выше главной диагонали");
        }
        setIsDeterminantCalculated(false);
        super.setElement(row, column, value);
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
        }
        setIsDeterminantCalculated(true);
        return getDeterminant();
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