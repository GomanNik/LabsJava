public class PalindromeFilter implements Filter {
    @Override
    public boolean apply(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}