public class FinanceReportProcessor {

    public static FinanceReport filterPaymentsByLastName(FinanceReport financeReport, char startingCharacter){
        if (!Character.isLetter(startingCharacter)) {
            throw new IllegalArgumentException("Недопустимый символ");
        }
        int count = 0;
        for (Payment payment : financeReport.getPayments()) {
            if (payment.getFullName().charAt(0) == startingCharacter) {
                count++;
            }
        }
        Payment[] filteredPaymentsArray = new Payment[count];
        int index = 0;
        for (Payment payment : financeReport.getPayments()) {
            if (payment.getFullName().charAt(0) == startingCharacter) {
                filteredPaymentsArray[index++] = payment;
            }
        }
        return new FinanceReport(filteredPaymentsArray, financeReport.getReportAuthor(), financeReport.getReportDate());
    }

    public static FinanceReport filterPaymentsByAmount(FinanceReport financeReport, int maxAmount)  {
        if (maxAmount < 0) {
            throw new IllegalArgumentException("Недопустимое значение максимальной суммы");
        }
        int count = 0;
        for (Payment payment : financeReport.getPayments()) {
            if (payment.getAmount() < maxAmount) {
                count++;
            }
        }
        Payment[] filteredPaymentsArray = new Payment[count];
        int index = 0;

        for (Payment payment : financeReport.getPayments()) {
            if (payment.getAmount() < maxAmount) {
                filteredPaymentsArray[index++] = payment;
            }
        }
        return new FinanceReport(filteredPaymentsArray, financeReport.getReportAuthor(), financeReport.getReportDate());
    }
}