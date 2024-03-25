import java.util.Objects;

public class PackagedPieceProduct extends PieceProduct implements PackagingProduct{
    private int quantity;
    private Packaging pack;

    public PackagedPieceProduct(int quantity, PieceProduct product, Packaging packaging) {
        super(product.getName(), product.getDescription(), product.getWeightPerPiece());

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity не может быть отрицательным");
        }

        if (packaging == null) {
            throw new NullPointerException("Packaging object не существует");
        }

        this.quantity = quantity;
        this.pack = packaging;
    }
    @Override
    public double getNetWeight() {
        return quantity * super.getWeightPerPiece();
    }

    @Override
    public double getGrossWeight() {
        return pack.getWeight() + (quantity * super.getWeightPerPiece());
    }

    public Packaging getPack() {
        return pack;
    }

    public void setPack(Packaging pack) {
        if (pack == null) {
            throw new NullPointerException("Packaging object не существует");
        }
        this.pack = pack;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity не может быть отрицательным");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PackagedPieceProduct{" +
                "quantity=" + quantity +
                ", packaging=" + pack +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return quantity == that.quantity && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, pack);
    }
}