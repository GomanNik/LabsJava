import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DataDemo {
    public static List<Integer> getAll(Data data) {
        List<Integer> allNumbers = new ArrayList<>();
        Iterator<Integer> iterator = data.iterator();

        while (iterator.hasNext()) {
            allNumbers.add(iterator.next());
        }

        return allNumbers;
    }
}