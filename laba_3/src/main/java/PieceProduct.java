import java.util.Objects;

public class PieceProduct extends Product {
    private double weightPerPiece;

    public PieceProduct(String name, String description, double weightPerPiece) {
        super(name, description);

        if (weightPerPiece <= 0) {
            throw new IllegalArgumentException("Weight per piece не можеть быть отрицательным");
        }

        this.weightPerPiece = weightPerPiece;
    }

    public double getWeightPerPiece() {
        return weightPerPiece;
    }

    public void setWeightPerPiece(double weightPerPiece) {
        if (weightPerPiece <= 0) {
            throw new IllegalArgumentException("Weight per piece must be greater than zero.");
        }

        this.weightPerPiece = weightPerPiece;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getDescribe() {
        return super.getDescription();
    }

    public void setDescribe(String describe) {
        super.setDescription(describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weightPerPiece);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (!super.equals(obj))
            return false;
        PieceProduct that = (PieceProduct) obj;
        return Double.compare(that.weightPerPiece, weightPerPiece) == 0;
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                "weightPerPiece=" + weightPerPiece +
                '}';
    }
}