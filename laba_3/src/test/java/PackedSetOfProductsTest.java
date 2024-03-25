import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PackedSetOfProductsTest {

    @Test
    public void testGetGrossWeight() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        WeightedProduct weightedProduct = new WeightedProduct("Яблоки", "Свежие яблоки");
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(weightedProduct, 2.0, packaging);

        PackagingProduct[] batch = {packagedPieceProduct, packagedWeightedProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch", batch);

        double grossWeight = packagedPieceProduct.getGrossWeight() + packagedWeightedProduct.getGrossWeight();

        assertEquals(grossWeight, packedSetOfProducts.getGrossWeight(), 0.001);
    }

    @Test
    public void gettersTests() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        WeightedProduct weightedProduct = new WeightedProduct("Яблоки", "Свежие яблоки");
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(weightedProduct, 2.0, packaging);


        PackagingProduct[] batch = {packagedPieceProduct, packagedWeightedProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch", batch);

        assertEquals("Batch", packedSetOfProducts.getDescribe());
        assertEquals(batch, packedSetOfProducts.getBatch());
    }

    @Test
    public void testNullBatchOrDescribeConstructor() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        WeightedProduct weightedProduct = new WeightedProduct("Яблоки", "Свежие яблоки");
        PackagedWeightedProduct packagedWeightedProduct = new PackagedWeightedProduct(weightedProduct, 2.0, packaging);


        PackagingProduct[] batch = {packagedPieceProduct, packagedWeightedProduct};

        assertThrows(Exception.class, () ->new PackedSetOfProducts("Null Batch", null));
        assertThrows(Exception.class, () ->new PackedSetOfProducts(null, batch));
    }

    @Test
    public void testSetDescribe() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        PackagingProduct[] batch = {packagedPieceProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Test Batch", batch);

        packedSetOfProducts.setDescribe("New Describe");
        assertEquals("New Describe", packedSetOfProducts.getDescribe());
    }

    @Test
    public void testSetNullDescribe() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        PackagingProduct[] batch = {packagedPieceProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Test Batch", batch);

        assertThrows(Exception.class, () ->packedSetOfProducts.setDescribe(null));
    }

    @Test
    public void testSetBatch() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);
        PackagedPieceProduct packagedPieceProductNew = new PackagedPieceProduct(5, pieceProduct, packaging);

        PackagingProduct[] batch = {packagedPieceProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Test Batch", batch);
        PackagingProduct[] newBatch = {packagedPieceProductNew};

        packedSetOfProducts.setBatch(newBatch);
        assertEquals(newBatch, packedSetOfProducts.getBatch());
    }

    @Test
    public void testSetNullBatch() {
        Packaging packaging = new Packaging("Коробка из картона",1);
        PieceProduct pieceProduct = new PieceProduct("Продукт", "Описание", 10.0);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct, packaging);

        PackagingProduct[] batch = {packagedPieceProduct};

        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Test Batch", batch);


        assertThrows(Exception.class, () ->packedSetOfProducts.setBatch(null));
    }
}