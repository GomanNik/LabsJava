public interface IMatrix {

    double getElement(int row, int column);

    void setElement(int row, int column, double value);

    double calculateDeterminant();
}