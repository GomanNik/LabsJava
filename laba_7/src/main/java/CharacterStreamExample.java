import java.io.*;

public class CharacterStreamExample {
    public static void writeIntegers(int[] arr, String fileName) throws IOException {
        if(fileName.isEmpty()) throw new NullPointerException("некорректный fileName");
        if (arr == null ) throw new IllegalArgumentException("пустой массив");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : arr) {
                writer.write(num + " ");
            }
            writer.write("\n");
        }
    }

    public static int[] readIntegers(String fileName, int n) throws IOException {
        if(fileName.isEmpty()) throw new NullPointerException("некорректный fileName");
        if (n <0) throw new IllegalArgumentException("некорректный n");
        int[] result = new int[n];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] numbersAsString = line.split(" ");
            for (int i = 0; i < n; i++) {
                result[i] = Integer.parseInt(numbersAsString[i]);
            }
        }
        return result;
    }
}