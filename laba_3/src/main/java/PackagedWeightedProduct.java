import java.util.Objects;

public class PackagedWeightedProduct extends WeightedProduct implements PackagingProduct{
    private Packaging packaging;
    private double weight;

    public PackagedWeightedProduct(WeightedProduct product,double weight, Packaging packaging)  {
        super(product.getName(), product.getDescription());
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight не может быть отрицательным");
        }
        if (packaging==null ) {
            throw new IllegalArgumentException("Packaging не может быть пустым");
        }
        this.weight = weight;
        this.packaging = packaging;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public double getProductWeight() {
        return weight;
    }

    public void setPackaging(Packaging packaging) {
        if (packaging.getName() == null || packaging.getName().isEmpty()) {
            throw new IllegalArgumentException("packaging не может быть пустым");
        }
        this.packaging = packaging;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight не может быть отрицательным");
        }
        this.weight = weight;
    }

    @Override
    public double getNetWeight() {
        return weight;
    }

    @Override
    public double getGrossWeight() {
//        if (weight < 0 || packaging.getWeight() < 0) {
//            throw new IllegalArgumentException("Вес не может быть отрицательным");
//        }
        return weight + packaging.getWeight();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedWeightedProduct that = (PackagedWeightedProduct) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(packaging, that.packaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packaging, weight);
    }

    @Override
    public String toString() {
        return "PackagedWeightedProduct{" +
                "packaging=" + packaging +
                ", weight=" + weight +
                '}';
    }
}