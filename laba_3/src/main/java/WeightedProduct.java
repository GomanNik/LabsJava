public class WeightedProduct extends Product {
    public WeightedProduct(String name, String describe) {
        super(name, describe);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "WeightProducts{" +
                "name='" + getName() + '\'' +
                ", describe='" + getDescription() + '\'' +
                '}';
    }
}
