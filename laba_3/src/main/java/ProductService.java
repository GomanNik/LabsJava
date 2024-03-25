public class ProductService {
    public static int countByFilter(PackedSetOfProducts batch, Filter filter) {
        if (batch == null) {
            throw new NullPointerException("Объекта не существует");
        } else if (filter == null) {
            throw new NullPointerException("Объекта не существует");
        }
        int count = 0;
        for (PackagingProduct item : batch.getBatch()) {
            if (filter.apply(((Product)item).getName())) {
                count++;
            }
        }
        return count;
    }
}
