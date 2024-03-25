import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getName() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "Яблоки";
        assertEquals(testString,product.getName());
    }
    @Test
    void setNameWithNegativeValue() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "";
        assertThrows(Exception.class, () ->product.setName(testString));
    }

    @Test
    void setName() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "Груши";
        product.setName(testString);
        assertEquals(testString,product.getName());
    }

    @Test
    void getDescription() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "Вкусные, красные, сладкие";

        assertEquals(testString,product.getDescription());
    }
    @Test
    void setDescription() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "Не очень вкусные, Не очень красные, Не очень сладкие";
        product.setDescription(testString);
        assertEquals(testString,product.getDescription());
    }
    @Test
    void setDescriptionWithNegativeValue() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");

        assertThrows(Exception.class, () ->product.setDescription(null));
    }

    @Test
    void testEquals() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        Product secondProduct = new Product("Яблоки","Вкусные, красные, сладкие");

        assertEquals(product,secondProduct);
    }

    @Test
    void testToString() {
        Product product = new Product("Яблоки","Вкусные, красные, сладкие");
        String testString = "Product{name='Яблоки', description='Вкусные, красные, сладкие'}";
        assertEquals(testString, product.toString());

    }
}