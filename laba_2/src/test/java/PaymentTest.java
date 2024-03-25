import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class PaymentTest {

    @Test
    public void testSetFullName() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        payment.setFullName("Jane Doe");
        assertEquals("Jane Doe", payment.getFullName());
    }

    @Test
    public void testSetFullNameWithNull() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.setFullName(null));
    }

    @Test
    public void testSetDay() {

        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        payment.setDay(15);
        assertEquals(15, payment.getDay());
    }

    @Test
    public void testSetDayInvalidValue() {

        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.setDay(32));
    }

    @Test
    public void testSetMonth() {

        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        payment.setMonth(6);
        assertEquals(6, payment.getMonth());
    }

    @Test
    public void testSetMonthInvalidValue() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.setMonth(13));
    }

    @Test
    public void testSetYear() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        payment.setYear(2024);
        assertEquals(2024, payment.getYear());
    }

    @Test
    public void testSetYearNegativeValue() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.setYear(-2023));
    }

    @Test
    public void testSetAmount() {

        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        payment.setAmount(6000);
        assertEquals(6000, payment.getAmount());
    }

    @Test
    public void testSetAmountNegativeValue() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.setAmount(-500));
    }

    @Test
    public void testEquals() {
        Payment payment1 = new Payment("John Doe", 1, 12, 2023, 5000);
        Payment payment2 = new Payment("John Doe", 1, 12, 2023, 5000);
        payment1.equals(payment2);
    }

    @Test
    public void testEqualsWithNull() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);

        assertThrows(Exception.class, () -> payment.equals(null));
    }

    @Test
    public void testHashCode() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        assertNotNull(payment.hashCode());
    }

    @Test
    public void testToString() {
        Payment payment = new Payment("John Doe", 1, 12, 2023, 5000);
        assertNotNull(payment.toString());
    }
}