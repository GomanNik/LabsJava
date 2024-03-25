import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportTest {
    @Test
    public void FinanceReport() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment payment = new Payment("3", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета",2022, 1, 1);
        FinanceReport copiedFinanceReport = new FinanceReport(financeReport);
        financeReport.setPayment(0, payment);
        assertNotEquals(financeReport, copiedFinanceReport);
    }
    @Test
    public void getNumberOfPayments() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета",2022, 1, 1);
        assertEquals(2,financeReport.getNumberOfPayments());

    }
    @Test
    public void testGetPayment() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета",2022, 1, 1);
        assertEquals(financeReport.getPayment(0),firstPayment);
    }

    @Test
    public void testGetPaymentWithInvalidIndex() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);
        assertThrows(Exception.class, () -> financeReport.getPayment(-1));
    }
    @Test
    public void testSetReportAuthor() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);
        String newAuthor = "Новый автор";
        financeReport.setReportAuthor(newAuthor);
        assertEquals(newAuthor,financeReport.getReportAuthor());

    }
    @Test
    public void testSetPayment() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);

        financeReport.setPayment( 0, secondPayment);
        assertEquals(secondPayment,financeReport.getPayment(0));

    }
    @Test
    public void testSetPaymentWithInvalidIndex() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);


        assertThrows(Exception.class, () ->financeReport.setPayment( -1, secondPayment));
    }

    @Test
    public void testSetReportAuthorWithNullValue() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);
        String newAuthor = "";

        assertThrows(Exception.class, () ->financeReport.setReportAuthor(newAuthor));
    }

    @Test
    public void testSetReportDate() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        Payment[] payment = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);
        financeReport.setReportDate(2022,10,12);
        int[] reportDate = {2022,10,12};
        for (int i=0;i<3;i++) {
            assertEquals(reportDate[i], financeReport.getReportDate()[i]);
        }
    }

    @Test
    public void testSetReportDateWithNullValue() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment[] payments = {firstPayment,secondPayment,};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);

        assertThrows(Exception.class, () ->financeReport.setReportDate(0, 0, 0));
    }

    @Test
    public void testSetPayments() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);

        Payment thirdPayment = new Payment("Third", 1, 12, 2023, 3000);
        Payment fourthPayment = new Payment("Fourth", 1, 12, 2023, 4000);

        Payment[] newPayments = {thirdPayment, fourthPayment};
        financeReport.setPayments(newPayments);
        assertEquals(newPayments,financeReport.getPayments());
    }

    @Test
    public void testSetPaymentsWithDifferentLengths() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);

        Payment[] payments = {firstPayment, secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Автор отчета", 2022, 1, 1);

        Payment[] newPayments = {};

        assertThrows(Exception.class, () -> financeReport.setPayments(newPayments));

    }
}