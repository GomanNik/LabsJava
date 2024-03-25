public class StringProcessor {

    public static String repeatString(String s, int N) {
        if (N < 0) {
            throw new IllegalArgumentException("N отрицательное");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(s + " ");
        }
        return result.toString();
    }

    public static int countOccurrences(String mainString, String subString) {
        if (subString == null || subString.isEmpty() || mainString == null || mainString.isEmpty()) {
            throw new IllegalArgumentException("subString и mainString не могут быть пустыми");
        }
        int count = 0;
        int lastIndex = 0;
        while ((lastIndex = mainString.indexOf(subString, lastIndex)) != -1) {
            count++;
            lastIndex += 1;
        }
        return count;
    }
    public static String replaceDigitsWithWords(String input) {
        input=input.replace("1", "один");
        input=input.replace("2", "два");
        input=input.replace("3", "три");
        return input;
    }
    public static void removeEverySecondChar(StringBuilder string) {
        for (int i = 0; i < string.length(); i += 1) {
            string.deleteCharAt(i);
        }
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}