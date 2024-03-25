import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackagingTest {

    @Test
    void getName() {
        Packaging packaging = new Packaging("Коробка из картона", 1);
        String testString = "Коробка из картона";
        assertEquals(testString, packaging.getName());
    }

    @Test
    void setName() {
        Packaging packaging = new Packaging("Коробка из картона", 1);
        String testString = "Деревянная коробка";
        packaging.setName(testString);
        assertEquals(testString, packaging.getName());
    }

    @Test
    void setNameWithNegativeValue() {
        Packaging packaging = new Packaging("Коробка из картона", 1);
        String testString = "";

        assertThrows(Exception.class, () -> packaging.setName(testString));
    }

    @Test
    void getWeight() {
        Packaging packaging = new Packaging("Коробка из картона", 10);
        assertEquals(10, packaging.getWeight());
    }

    @Test
    void SetWeight() {
        Packaging packaging = new Packaging("Box", 10.5);
        packaging.setWeight(15.3);
        assertEquals(15.3, packaging.getWeight());
    }

    @Test
    void setWeightWithNegativeValue() {
        Packaging packaging = new Packaging("Box", 10.5);

        assertThrows(Exception.class, () -> packaging.setWeight(-15.3));
    }

    @Test
    void testHashCode() {
        Packaging packaging1 = new Packaging("Box", 5.0);
        Packaging packaging2 = new Packaging("Box", 5.0);
        assertEquals(packaging1.hashCode(), packaging2.hashCode());
    }

    @Test
    void testEquals() {
        Packaging packaging1 = new Packaging("Box", 10.5);
        Packaging packaging2 = new Packaging("Box", 10.5);
        assertTrue(packaging1.equals(packaging2));
    }

    @Test
    void testToString() {
        Packaging packaging1 = new Packaging("Box", 10.5);
        String testString = "Packaging{name='Box', weight=10.5}";
        assertEquals(testString, packaging1.toString());
    }
}