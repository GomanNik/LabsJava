public class BeginStringFilter implements Filter {
    private String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern == null) {
            throw new NullPointerException("Объекта не существует");
        }
        this.pattern = pattern;
    }

    public boolean apply(String str) {
        if (str == null) {
            throw new NullPointerException("Объекта не существует");
        }
        return str.startsWith(pattern);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        if (pattern == null) {
            throw new NullPointerException("Объекта не существует");
        }
        this.pattern = pattern;
    }
}
