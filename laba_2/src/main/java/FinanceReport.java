import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {
    private Payment[] payments;
    private String reportAuthor;
    private int day;
    private int month;
    private int year;

    public FinanceReport(Payment[] payments, String reportAuthor, int year, int month, int day) {
        this.payments = payments;
        this.reportAuthor = reportAuthor;
        setReportDate(year, month, day);
    }
    public FinanceReport(Payment[] payments, String reportAuthor, int[]reportDate) {
        this.payments = payments;
        this.reportAuthor = reportAuthor;
        setReportDate(reportDate[0], reportDate[1], reportDate[2]);
    }

    public FinanceReport(FinanceReport other) {
        this.reportAuthor = other.reportAuthor;
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;

        this.payments = new Payment[other.payments.length];

        for (int i = 0; i < this.payments.length; i++) {
            this.payments[i] = new Payment(other.payments[i]);
        }
    }

    public int getNumberOfPayments() {
        return payments.length;
    }

    public Payment getPayment(int index) {
        return payments[index];
    }

    public void setPayment(int index, Payment payment) {
        if (index >= 0 && index < payments.length) {
            payments[index] = payment;
        } else {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }

    public String getReportAuthor() {
        return reportAuthor;
    }

    public int[] getReportDate() {
        int[] reportDate = {this.year,this.month,this.day};
        return reportDate;
    }

    public void setReportAuthor(String reportAuthor) {
        if (reportAuthor == null || reportAuthor.isEmpty()) {
            throw new IllegalArgumentException("reportAuthor не может быть пустым");
        }
        this.reportAuthor = reportAuthor;
    }

    public void setReportDate(int year, int month, int day) {
        if (day<1 || day>30 || month<1 || month>12 || year<0) {
            throw new IllegalArgumentException("Некорректное значение даты");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        if (payments == null || payments.length==0) {
            throw new IllegalArgumentException("payments не может быть пустым");
        }

        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return day == that.day && month == that.month && year == that.year && Arrays.equals(payments, that.payments) && Objects.equals(reportAuthor, that.reportAuthor);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(reportAuthor, day, month, year);
        result = 31 * result + Arrays.hashCode(payments);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Автор: %s, дата: %d.%d.%d, Платежи: [\n", reportAuthor, day, month, year));

        for (Payment payment : payments) {
            sb.append(String.format("\tПлательщик: %s, дата: %d.%d.%d, сумма: %d руб. %d коп.\n",
                    payment.getFullName(), payment.getDay(), payment.getMonth(), payment.getYear(),
                    payment.getAmount() / 100, payment.getAmount() % 100));
        }

        sb.append("]");

        return sb.toString();
    }
}