
import java.util.Objects;

public class PackedSetOfProducts {

        private String describe;
        private PackagingProduct[] batch;

        public PackedSetOfProducts(String describe, PackagingProduct[] batch) {
            if (batch == null) {
                throw new NullPointerException("Объекта не существует");
            }
            if (describe == null || describe.isEmpty()) {
                throw new NullPointerException("Строки не существует или она пустая");
            }

            this.describe = describe;
            this.batch = batch;
        }

        public double getGrossWeight() {
            double sum = 0;
            for (PackagingProduct packagingProducts : batch) {
                sum += packagingProducts.getGrossWeight();
            }
            return sum;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            if (describe == null || describe.isEmpty()) {
                throw new NullPointerException("Строки не существует или она пустая");
            }
            this.describe = describe;
        }

        public PackagingProduct[] getBatch() {
            return batch;
        }

        public void setBatch(PackagingProduct[] batch) {
            if (batch == null) {
                throw new NullPointerException("Объекта не существует");
            }
            this.batch = batch;
        }

        @Override
        public String toString() {
            return "BatchOfProducts{" +
                    "describe='" + describe + '\'' +
                    ", batch=" + batch +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PackedSetOfProducts that = (PackedSetOfProducts) o;
            return Objects.equals(describe, that.describe) && Objects.equals(batch, that.batch);
        }

        @Override
        public int hashCode() {
            return Objects.hash(describe, batch);
        }
    }


