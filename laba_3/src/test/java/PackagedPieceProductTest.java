import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PackagedPieceProductTest {

    @Test
    void testGetNetWeight() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertEquals(50.0, packagedProduct.getNetWeight());
    }

    @Test
    void testGetGrossWeight() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertEquals(55.0, packagedProduct.getGrossWeight());
    }

    @Test
    void testSetPackWithNullPackaging() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertThrows(NullPointerException.class, () -> packagedProduct.setPack(null));
    }

    @Test
    void testSetQuantityWithNegativeValue() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertThrows(IllegalArgumentException.class, () -> packagedProduct.setQuantity(-1));
    }
    @Test
    void testGetPack() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertEquals(packaging,packagedProduct.getPack());
    }
    @Test
    void testSetPack() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        Packaging newPackaging = new Packaging("Самая лучшаяя коробка с Озон", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        packagedProduct.setPack(newPackaging);

        assertEquals(newPackaging,packagedProduct.getPack());
    }

    @Test
    void testSetPackWithNegative() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);

        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertThrows(NullPointerException.class, () -> {
            packagedProduct.setPack(null);
        });
    }

    @Test
    void testGetQuantity() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertEquals(5,packagedProduct.getQuantity());
    }
    @Test
    void testSetQuantity() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        packagedProduct.setQuantity(1000);

        assertEquals(1000,packagedProduct.getQuantity());
    }

    @Test
    void testSetQuantityWithNegative() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        Packaging packaging = new Packaging("Коробка", 5.0);
        PackagedPieceProduct packagedProduct = new PackagedPieceProduct(5, product, packaging);

        assertThrows(IllegalArgumentException.class, () -> {
            packagedProduct.setQuantity(-1000);
        });
    }
}