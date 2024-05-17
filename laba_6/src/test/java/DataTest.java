import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class DataTest {
    @Test
    public void testDataAndGroup(){
        Data data = new Data("Test Data",
                    new Group(1,1,2,3,4),
                    new Group(2,-1,1,4,100));

        assertEquals(2,data.getGroups().length);
        assertEquals(1,data.getGroups()[0].getGroupId());
        assertArrayEquals(new int[]{-1,1,4,100},data.getGroups()[1].getData());

        data.setGroups(new  Group[]{new Group(1,1)});
        assertArrayEquals(new int[]{1},data.getGroups()[0].getData());

        data.getGroups()[0].setData(new int[] {1,2,3,4,5,6});
        data.getGroups()[0].setGroupId(1000);

        assertEquals(1000,data.getGroups()[0].getGroupId());
        assertArrayEquals(new int[] {1,2,3,4,5,6},data.getGroups()[0].getData());

    }
    @Test
    public void testGetName() {
        Data data = new Data("Test Data");
        assertEquals("Test Data", data.getName());
    }

    @Test
    public void testSetName() {
        Data data = new Data("Initial Name");
        data.setName("New Name");
        assertEquals("New Name", data.getName());
    }

    @Test
    public void testGetTotalLength() {
        Group group1 = new Group(1, 1, 2);
        Group group2 = new Group(2, 3, 4, 5);
        Data data = new Data("Test Data", group1, group2);

        assertEquals(5, data.getTotalLength());
    }

    @Test
    public void testIterator() {
        Group group1 = new Group(1, 1, 2);
        Group group2 = new Group(2, 3, 4, 5);
        Data data = new Data("Test Data", group1, group2);

        Iterator<Integer> iterator = data.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }
}