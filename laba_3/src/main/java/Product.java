import java.util.Objects;
public class Product {
    private String name;
    private String description;

    public Product(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Строки не существует или она пустая");
        }
        if (description == null || description.isEmpty()) {
            throw new NullPointerException("Строки не существует или она пустая");
        }
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Строки не существует или она пустая");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new NullPointerException("Строки не существует или она пустая");
        }
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
