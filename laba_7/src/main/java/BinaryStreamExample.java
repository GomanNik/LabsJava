import java.io.*;

public class BinaryStreamExample {
    public static void writeIntegers(int[] arr, String fileName) throws IOException {
        if(fileName.isEmpty()) throw new NullPointerException("некорректный fileName");
        if (arr == null) throw new IllegalArgumentException("пустой массив");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int num : arr) {
                dos.writeInt(num);
            }
        }
    }

    public static int[] readIntegers(String fileName, int n) throws IOException {
        if(fileName.isEmpty()) throw new NullPointerException("некорректный fileName");
        if (n <0) throw new IllegalArgumentException("некорректный n");
        int[] result = new int[n];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            for (int i = 0; i < n; i++) {
                result[i] = dis.readInt();
            }
        }
        return result;
    }
}