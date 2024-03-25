public class DigitFilter implements Filter {
    @Override
    public boolean apply(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string не может быть null");
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}