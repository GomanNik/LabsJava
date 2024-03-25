import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;


class CharacterStreamExampleTest {

    @Test
    void testWriteIntegers_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CharacterStreamExample.writeIntegers(null, "test.bin");
        });
    }

    @Test
    void testReadIntegers_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CharacterStreamExample.readIntegers("test.bin", -1);
        });
    }

    @Test
    void testWriteIntegers_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            CharacterStreamExample.writeIntegers(new int[]{1, 2, 3}, "");
        });
    }

    @Test
    void testReadIntegers_NullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            CharacterStreamExample.readIntegers("", 3);
        });
    }

    @Test
    void testWriteIntegersAndReadIntegers() throws IOException {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        CharacterStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = CharacterStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithDifferentLengths() throws IOException {
        int[] expected = new int[]{11, 22, 33};
        CharacterStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = CharacterStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithEmptyFile() throws IOException {
        int[] expected = new int[0];
        CharacterStreamExample.writeIntegers(expected, "empty.bin");
        int[] actual = CharacterStreamExample.readIntegers("empty.bin", expected.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testWriteIntegersAndReadIntegersWithDifferentNumbers() throws IOException {
        int[] expected = new int[]{100, 200, 300, 400};
        CharacterStreamExample.writeIntegers(expected, "test.bin");
        int[] actual = CharacterStreamExample.readIntegers("test.bin", expected.length);
        assertArrayEquals(expected, actual);
    }
}