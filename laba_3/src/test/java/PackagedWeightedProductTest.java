import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PackagedWeightedProductTest {

    @Test
    void testConstructorWithValidValues() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        assertEquals("Товар", packagedProduct.getName());
        assertEquals("Описание", packagedProduct.getDescription());
        assertEquals(5.0, packagedProduct.getProductWeight());
        assertEquals(packaging, packagedProduct.getPackaging());
    }

    @Test
    void testConstructorWithInvalidWeight() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);

        assertThrows(IllegalArgumentException.class, () -> new PackagedWeightedProduct(product, -1.0, packaging));
    }

    @Test
    void testConstructorWithNullPackaging() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");

        assertThrows(IllegalArgumentException.class, () -> new PackagedWeightedProduct(product, 5.0, null));
    }

    @Test
    void testSetPackagingWithValidValues() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        Packaging newPackaging = new Packaging("Новая Красивая Коробка", 3.0);
        packagedProduct.setPackaging(newPackaging);

        assertEquals(newPackaging, packagedProduct.getPackaging());
    }

    @Test
    void testSetPackagingWithInvalidName() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        Packaging invalidPackaging = new Packaging("", 3.0);

        assertThrows(IllegalArgumentException.class, () -> packagedProduct.setPackaging(invalidPackaging));
    }

    @Test
    void testSetWeightWithValidValue() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        packagedProduct.setWeight(10.0);

        assertEquals(10.0, packagedProduct.getProductWeight());
    }

    @Test
    void testSetWeightWithInvalidValue() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        assertThrows(IllegalArgumentException.class, () -> packagedProduct.setWeight(-1.0));
    }

    @Test
    void testGetNetWeight() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        assertEquals(5.0, packagedProduct.getNetWeight());
    }

    @Test
    void testGetGrossWeight() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        assertEquals(7.0, packagedProduct.getGrossWeight());
    }

    @Test
    void testHashCode() {
        WeightedProduct product1 = new WeightedProduct("Товар", "Описание");
        Packaging packaging1 = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct1 = new PackagedWeightedProduct(product1, 5.0, packaging1);

        WeightedProduct product2 = new WeightedProduct("Товар", "Описание");
        Packaging packaging2 = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct2 = new PackagedWeightedProduct(product2, 5.0, packaging2);

        assertEquals(packagedProduct1.hashCode(), packagedProduct2.hashCode());
    }
    @Test
    void testEqualsCode() {
        WeightedProduct product1 = new WeightedProduct("Товар", "Описание");
        Packaging packaging1 = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct1 = new PackagedWeightedProduct(product1, 5.0, packaging1);

        WeightedProduct product2 = new WeightedProduct("Товар", "Описание");
        Packaging packaging2 = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct2 = new PackagedWeightedProduct(product2, 5.0, packaging2);
        assertTrue(packagedProduct1.equals(packagedProduct2));
    }

    @Test
    void testToString() {
        WeightedProduct product = new WeightedProduct("Товар", "Описание");
        Packaging packaging = new Packaging("Коробка", 2.0);
        PackagedWeightedProduct packagedProduct = new PackagedWeightedProduct(product, 5.0, packaging);

        assertEquals("PackagedWeightedProduct{packaging=Packaging{name='Коробка', weight=2.0}, weight=5.0}", packagedProduct.toString());
    }
}