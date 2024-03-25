import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;

class getFilesWithExtensionTest {

    @Test
    public void testGetFilesWithExtension() throws IOException {
        List<String> files = getFilesWithExtension.getFilesWithExtension("D:\\laba_7\\src\\main\\java", ".txt");
        assertEquals(2, files.size());
        assertTrue(files.contains("file1.txt"));
        assertTrue(files.contains("file2.txt"));
    }

    @Test
    public void testEmptyDirectoryPath() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            getFilesWithExtension.getFilesWithExtension("", ".txt");
        });
    }

    @Test
    public void testEmptyExtension() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            getFilesWithExtension.getFilesWithExtension("путь_к_директории", "");
        });
    }
}