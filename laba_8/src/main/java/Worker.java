public class Worker extends Human {

    private String positionHeld;

    public Worker(String firstName, String lastName, String surname, int age, String positionHeld) {
        super(lastName, firstName, surname, age);

        if(age<18) throw new IllegalArgumentException("возраст работника должен быть > 18! ");

        this.positionHeld= positionHeld;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        if (positionHeld.isEmpty()) {
            throw new IllegalArgumentException("некорректная Должность");
        }
        this.positionHeld = positionHeld;
    }
}