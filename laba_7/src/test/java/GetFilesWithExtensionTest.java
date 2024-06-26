import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


class GetFilesWithExtensionTest {

    @Test
    public void testGetFilesWithExtension() throws IOException {
        List<String> files = GetFilesWithExtension.getFilesWithExtension
        ("C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\src\\main\\java", ".txt");

        assertEquals(2, files.size());
        assertTrue(files.contains("file1.txt"));
        assertTrue(files.contains("file2.txt"));
    }
    @Test
    void testSearchFilesInDirectory() {
        String directoryPath = "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\src\\main\\java";
        String regex = "file[0-9]+\\.txt"; // Поиск файлов, название которых начинается с "file" и содержит цифры и ".txt"

        List<String> foundFiles = GetFilesWithExtension.searchFiles(directoryPath, regex);
        List<String> expected = Arrays.asList(
                "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\src\\main\\java\\file1.txt",
                "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\src\\main\\java\\file2.txt"
        );

        assertEquals(expected ,foundFiles);
    }
    @Test
    void testSearchFilesInDirectorySecond() {
        String directoryPath = "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7";
        String regex = ".*test.*"; // Поиск файлов, название которых начинается с "file" и содержит цифры и ".txt"

        List<String> foundFiles = GetFilesWithExtension.searchFiles(directoryPath, regex);
        List<String> expected = Arrays.asList(
                "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\test.bin",
                "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\testfile.txt",
                "C:\\Users\\Goman Nikita\\Desktop\\LabsJava\\laba_7\\testHouse.ser"
        );

        assertEquals(expected ,foundFiles);
    }
    @Test
    void testInvalidDirectoryPath() {
        String directoryPath = "invalid/directory/path";
        String regex = ".*"; // Регулярное выражение для поиска всех файлов

        List<String> foundFiles = GetFilesWithExtension.searchFiles(directoryPath, regex);

        assertTrue(foundFiles.isEmpty());
    }

    @Test
    public void testEmptyDirectoryPath() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            GetFilesWithExtension.getFilesWithExtension("", ".txt");
        });
    }

    @Test
    public void testEmptyExtension() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            GetFilesWithExtension.getFilesWithExtension("путь_к_директории", "");
        });
    }



}