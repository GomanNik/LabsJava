import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GetFilesWithExtension {
    public static List<String> getFilesWithExtension(String directoryPath, String extension) {
        if (directoryPath == null || extension == null) {
            throw new IllegalArgumentException("Путь к директории и регулярное выражение не должны быть null.");
        }

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Указанный путь не является директорией.");
        }

        List<String> fileList = new ArrayList<>();

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    fileList.add(file.getName());
                }
            }
        }

        return fileList;
    }
    public static List<String> searchFiles(String directoryPath, String regex){
        List<String> fileList = new ArrayList<>();
        searchFiles(directoryPath,regex,fileList);
        return fileList;
    }
    private static void searchFiles(String directoryPath, String regex, List<String> foundFiles) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file.getAbsolutePath(), regex, foundFiles);
                } else {
                    if (Pattern.matches(regex, file.getName())) {
                        foundFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
