import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

class RandomAccessFileExampleTest {

    @Test
    void readIntegersFromPositionWithOneElem() throws IOException {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        long position = 1;

        assertArrayEquals(new int[]{2},RandomAccessFileExample.readIntegersFromPosition("test.bin",position,1));
    }
    @Test
    void readIntegersFromPosition1() throws IOException {
        int[] expected = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        long position = 10;

        assertArrayEquals(new int[]{1,1,1,1,1},RandomAccessFileExample.readIntegersFromPosition("test.bin",position,5));
    }
    @Test
    void readIntegersFromPositionWithNegative() throws IOException {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        long position = 40100140;

        assertThrows(NullPointerException.class,()->{
            RandomAccessFileExample.readIntegersFromPosition(null,position,5);
        });
        assertThrows(IllegalArgumentException.class,()->{
            RandomAccessFileExample.readIntegersFromPosition("test.bin",-5,5);
        });
        assertThrows(IllegalArgumentException.class,()->{
            RandomAccessFileExample.readIntegersFromPosition("test.bin",position,-5);
        });
    }
}