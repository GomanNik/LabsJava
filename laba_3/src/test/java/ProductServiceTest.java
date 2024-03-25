import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void countByFilterBeginStringFilter() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        PieceProduct pieceProduct1 = new PieceProduct("Продукт1", "Описание1", 0.5);
        PackagedPieceProduct packagedPieceProduct1 = new PackagedPieceProduct(5, pieceProduct1, packaging1);

        Packaging packaging2 = new Packaging("Коробка", 0.5);
        WeightedProduct weightedProduct1 = new WeightedProduct("Продукт22ткудорП", "Описание2");
        PackagedWeightedProduct packagedWeightedProduct1 = new PackagedWeightedProduct(weightedProduct1, 2.0, packaging2);

        PackagingProduct[] batch = {packagedPieceProduct1, packagedWeightedProduct1};
        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch 1", batch);

        int count = ProductService.countByFilter(packedSetOfProducts, new BeginStringFilter("Продукт"));
        assertEquals(2, count);
    }

    @Test
    public void countByFilterPalindromeFilter() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        PieceProduct pieceProduct1 = new PieceProduct("шалаш", "кто то заказал палатку, с определенной расскраской с кодовым названием 'шалаш' ", 0.5);
        PackagedPieceProduct packagedPieceProduct1 = new PackagedPieceProduct(5, pieceProduct1, packaging1);

        Packaging packaging2 = new Packaging("Коробка", 0.5);
        WeightedProduct weightedProduct1 = new WeightedProduct("заказ", "Описание2");
        PackagedWeightedProduct packagedWeightedProduct1 = new PackagedWeightedProduct(weightedProduct1, 2.0, packaging2);

        PackagingProduct[] batch = {packagedPieceProduct1, packagedWeightedProduct1};
        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch 1", batch);

        int count = ProductService.countByFilter(packedSetOfProducts, new PalindromeFilter());
        assertEquals(2, count);
    }

    @Test
    public void countByFilterDigitFilter() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        PieceProduct pieceProduct1 = new PieceProduct("123", "Единственный маршрут автобуса из Лузино в Омск", 0.5);
        // Под названием товара будем понимать Номер маршрута соответсвующего автобуса, а сам товар = автобус;

        PieceProduct pieceProduct2 = new PieceProduct("904", "Единственный маршрут маршрутного такси из Лузино в Омск", 0.5);
        // Под названием товара будем понимать Номер маршрута соответсвующего маршрутного такси, а сам товар = маршрутка;

        PackagedPieceProduct packagedPieceProduct1 = new PackagedPieceProduct(5, pieceProduct1, packaging1);
        PackagedPieceProduct packagedPieceProduct2 = new PackagedPieceProduct(5, pieceProduct2, packaging1);

        Packaging packaging2 = new Packaging("Коробка", 0.5);
        WeightedProduct weightedProduct1 = new WeightedProduct("001", "инвентарный номер чехла для автобуса 123");
        // Чехол необходим т.к. заявлено что кол-во автобусов 5, а ходит всего один =>все остальные стоят без дела =>
        // стоять просто так машинам "не полезно", значит им нужны чехлы :)
        PackagedWeightedProduct packagedWeightedProduct1 = new PackagedWeightedProduct(weightedProduct1, 2.0, packaging2);

        PackagingProduct[] batch = {packagedPieceProduct1, packagedWeightedProduct1,packagedPieceProduct2};
        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch 1", batch);

        int count = ProductService.countByFilter(packedSetOfProducts, new DigitFilter());
        assertEquals(3, count);
    }

    @Test
    public void countByFilterWitNegative() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        PieceProduct pieceProduct1 = new PieceProduct("Продукт1", "Описание1", 0.5);
        PackagedPieceProduct packagedPieceProduct = new PackagedPieceProduct(5, pieceProduct1, packaging1);

        PackagingProduct[] batch = {packagedPieceProduct};
        PackedSetOfProducts packedSetOfProducts = new PackedSetOfProducts("Batch 1", batch);

        assertThrows(NullPointerException.class, () -> ProductService.countByFilter(packedSetOfProducts, null));
    }
}