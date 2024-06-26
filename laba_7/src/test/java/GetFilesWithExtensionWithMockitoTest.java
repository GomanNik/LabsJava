import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GetFilesWithExtensionWithMockitoTest {

    @Mock
    private File mockFile;

    @Test
    public void testGetFilesWithExtension_NullDirectoryPath() {
        // Тестирование метода с пустым путем к директории
    }

    @Test
    public void testGetFilesWithExtension_NullExtension() {
        // Тестирование метода с пустым расширением
    }

    @Test
    public void testGetFilesWithExtension_NonDirectoryPath() {
        // Тестирование метода с недопустимым путем к директории
    }

    @Test
    public void testGetFilesWithExtension() {
        // Тестирование метода с корректными данными
    }

    @Test
    public void testSearchFiles() {
        // Тестирование метода поиска файлов
    }
}
