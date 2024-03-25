import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessFileExample {
    public static int[] readIntegersFromPosition(String fileName, long position, int numIntegers) throws IOException {
        if (fileName.isEmpty()) throw new NullPointerException("directoryPath не можеть быть пустым");
        if (position<0 || numIntegers <= 0) throw new IllegalArgumentException("Не можеть быть отрицательным");
        int[] result = new int[numIntegers];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            raf.seek(position * Integer.BYTES);
            for (int i = 0; i < numIntegers; i++) {
                result[i] = raf.readInt();
            }
        }

        return result;
    }
}