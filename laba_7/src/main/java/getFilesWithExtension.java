import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getFilesWithExtension {
    public static List<String> getFilesWithExtension(String directoryPath, String extension) {
        if (directoryPath.isEmpty()) throw new IllegalArgumentException("directoryPath не можеть быть пустым");
        if (extension.isEmpty()) throw new IllegalArgumentException("extension не можеть быть пустым");

        List<String> fileList = new ArrayList<>();
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if(files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    fileList.add(file.getName());
                }
            }
        }

        return fileList;
    }
}
