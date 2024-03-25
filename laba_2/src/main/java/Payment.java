public class Payment {
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int amount;

    public Payment(String fullName, int day, int month, int year, int amount) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }
    public Payment(Payment other) {
        this.fullName = other.fullName;
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        this.amount = other.amount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("fullName не может быть пустым");
        }
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10|| month==12) & day > 31) ||
                ((month==4 || month==6 || month==9 || month==11 & day > 30)) || (month==2 & day > 29)) {
            throw new IllegalArgumentException("day принимает значения от 1 до 30/31 (реже 28/29");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month принимает значения от 1 до 12");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("year не может быть отрицательным");
        }
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount не может быть отрицательным");
        }
        this.amount = amount;
    }

    public boolean equals(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("payment не может быть пустым");
        }
        return day == payment.day && month == payment.month && year == payment.year && amount == payment.amount &&  fullName == payment.fullName;
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        return result+ day + month + year + year + amount;
    }
    @Override
    public String toString() {
        return "Плательщик: " + fullName + ", дата: " + day + "." + month + "." + year + ", сумма: " + amount / 100 + " руб. " + amount % 100 + " коп.";
    }
}

