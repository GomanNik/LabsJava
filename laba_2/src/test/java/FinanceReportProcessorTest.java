import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FinanceReportProcessorTest {

    @Test
    void testFilterPaymentsByLastName() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment thirdPayment = new Payment("Third", 1, 12, 2023, 3000);

        Payment[] payments = {firstPayment, secondPayment, thirdPayment};
        Payment[] secondPayments = {secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Author", 2023, 12, 12);
        FinanceReport secondFinanceReport = new FinanceReport(secondPayments, "Author", 2023, 12, 12);

        FinanceReport filteredReport = FinanceReportProcessor.filterPaymentsByLastName(financeReport, 'S');
        assertEquals(secondFinanceReport,filteredReport);
    }
    @Test
    void testFilterPaymentsByLastNameWithInvalidValue() {

        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment thirdPayment = new Payment("Third", 1, 12, 2023, 3000);

        Payment[] payments = {firstPayment, secondPayment, thirdPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Author", 2023, 12, 12);

        assertThrows(Exception.class, () -> FinanceReportProcessor.filterPaymentsByLastName(financeReport, '#'));
    }
    @Test
    void testFilterPaymentsByAmount() {

        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment thirdPayment = new Payment("Third", 1, 12, 2023, 3000);

        Payment[] payments = {firstPayment,secondPayment,thirdPayment};
        Payment[] secondPayments = {firstPayment,secondPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Author", 2023, 12, 12);
        FinanceReport secondFinanceReport = new FinanceReport(secondPayments, "Author", 2023, 12, 12);

        FinanceReport filteredReport = FinanceReportProcessor.filterPaymentsByAmount(financeReport, 3000);
        assertEquals(secondFinanceReport, filteredReport);
    }
    @Test
    void testFilterPaymentsByAmountWithNegativeValue() {
        Payment firstPayment = new Payment("First", 1, 12, 2023, 1000);
        Payment secondPayment = new Payment("Second", 1, 12, 2023, 2000);
        Payment thirdPayment = new Payment("Third", 1, 12, 2023, 3000);

        Payment[] payments = {firstPayment, secondPayment, thirdPayment};
        FinanceReport financeReport = new FinanceReport(payments, "Author", 2023, 12, 12);

        assertThrows(Exception.class, () ->FinanceReportProcessor.filterPaymentsByAmount(financeReport, -150));
    }
}