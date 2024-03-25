import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


public class BinaryStreamExampleTest {

    @Test
    void testWriteIntegers_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryStreamExample.writeIntegers(null, "test.bin");
        });
    }

    @Test
    void testReadIntegers_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryStreamExample.readIntegers("test.bin", -1);
        });
    }

    @Test
    void testWriteIntegers_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            BinaryStreamExample.writeIntegers(new int[]{1, 2, 3}, "");
        });
    }

    @Test
    void testReadIntegers_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            BinaryStreamExample.readIntegers("", 3);
        });
    }

    @Test
    void testWriteIntegersAndReadIntegers() throws IOException {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = BinaryStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithDifferentLengths() throws IOException {
        int[] expected = new int[]{11, 22, 33};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = BinaryStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithEmptyFile() throws IOException {
        int[] expected = new int[0];
        BinaryStreamExample.writeIntegers(expected, "empty.bin");
        int[] actual = BinaryStreamExample.readIntegers("empty.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithDifferentNumbers() throws IOException {
        int[] expected = new int[]{100, 200, 300, 400};
        BinaryStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = BinaryStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }
}