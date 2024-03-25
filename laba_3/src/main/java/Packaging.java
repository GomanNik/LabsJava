import java.util.Objects;

public class Packaging {
    private String name;
    private double weight;

    public Packaging(String name, double weight) {
        if (name == null) {
            throw new NullPointerException("Строки не существует");
        } else if (weight < 0) {
            throw new IllegalArgumentException("Вес не может быть отрицательным");
        }
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight не может быть отрицательны");
        }
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Packaging packaging = (Packaging) obj;
        return Double.compare(packaging.weight, weight) == 0 && Objects.equals(name, packaging.name);
    }

    @Override
    public String toString() {
        return "Packaging{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
