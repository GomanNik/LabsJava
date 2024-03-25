import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceProductTest {
    @Test
    void testPieceProduct() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        assertEquals(10.0, product.getWeightPerPiece());
    }

    @Test
    void testPieceProductWithInvalidWeightPerPiece() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PieceProduct("Продукт", "Описание", -10.0);
        });
    }

    @Test
    public void testSetValidWeightPerPiece() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        product.setWeightPerPiece(2.0);
        assertEquals(2.0, product.getWeightPerPiece());
    }

    @Test
    public void testSetInvalidWeightPerPiece() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        assertThrows(IllegalArgumentException.class, () -> {
            product.setWeightPerPiece(-2.0);
        });
    }

    @Test
    public void testHashCode() {
        PieceProduct product1 = new PieceProduct("Продукт", "Описание", 10.0);
        PieceProduct product2 = new PieceProduct("Продукт", "Описание", 10.0);
        assertEquals(product1.hashCode(), product2.hashCode());
    }

//    @Test
//    public void testEqualsWithEqualObjects() {
//        PieceProduct product1 = new PieceProduct("Продукт", "Описание", 10.0);
//        PieceProduct product2 = new PieceProduct("Продукт", "Описание", 10.0);
//        assertTrue(product1.equals(product2));
//
//    }
//
//    @Test
//    public void testEqualsWithDifferentObjects() {
//        PieceProduct product1 = new PieceProduct("Продукт", "Описание", 10.0);
//        PieceProduct product2 = new PieceProduct("Продукт", "Описание", 10.0);
//        assertFalse(product1.equals(product2.toString()));
//    }

    @Test
    public void testToString() {
        PieceProduct product = new PieceProduct("Продукт", "Описание", 10.0);
        String expected = "PieceProduct{weightPerPiece=10.0}";
        assertEquals(expected, product.toString());
    }
}