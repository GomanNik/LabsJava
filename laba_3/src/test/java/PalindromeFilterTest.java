import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeFilterTest {

    @Test
    public void testApplyWithPalindrome() {

        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String palindrome = "абба";

        boolean result = palindromeFilter.apply(palindrome);

        assertTrue(result);
    }

    @Test
    public void testApplyWithNonPalindrome() {

        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String nonPalindrome = "привет";

        boolean result = palindromeFilter.apply(nonPalindrome);

        assertFalse(result);
    }
    @Test
    public void testApplyWithNonPalindromeSecond() {

        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String nonPalindrome = "привет";

        boolean result = palindromeFilter.apply(nonPalindrome);

        assertFalse(result);
    }

    @Test
    public void testApplyWithEmptyString() {

        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String emptyString = "";

        boolean result = palindromeFilter.apply(emptyString);

        assertTrue(result);
    }
    @Test
    public void testApplyWithDigit() {

        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String emptyString = "12aa21";

        boolean result = palindromeFilter.apply(emptyString);

        assertTrue(result);
    }

    @Test
    public void testApplyWithSingleCharacter() {
        PalindromeFilter palindromeFilter = new PalindromeFilter();
        String singleCharacter = "а";

        boolean result = palindromeFilter.apply(singleCharacter);

        assertTrue(result);
    }
}