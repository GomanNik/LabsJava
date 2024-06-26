import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class DataDemoTest {

    @Test
    public void testGetAll() {
        Group group1 = new Group(1, 1, 2);
        Group group2 = new Group(2, 3, 4, 5);
        Group group3 = new Group(2, 6,7,8,9);
        Group group4 = new Group(4, 10);
        Group group5 = new Group(5, 11,12,13);

        Data data = new Data("Test Data", group1, group2, group3, group4, group5);

        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        assertIterableEquals(expected, DataDemo.getAll(data));
    }
}