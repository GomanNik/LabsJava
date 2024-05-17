import java.util.Objects;

public class Human {
    private String lastName;
    private String firstName;
    private String surname;
    private int age;

    public Human(){}
    public Human(String lastName, String firstName, String surname, int age) {
        if (lastName.isEmpty() || firstName.isEmpty() || surname.isEmpty()) {
            throw new IllegalArgumentException("Некоретное ФИО");
        }
        if (age<=0 || age>116) {
            throw new IllegalArgumentException("Некоректное значение возраста");
            //Cамым старым человеком в мире на данный момент является 116-летняя
            // долгожительница Мария Браньяс Морера из Испании,
            // родившаяся 4 марта 1907 года
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Некоретная фамилия");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("Некоретное имя");
        }
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String patronymic) {
        if (patronymic.isEmpty()) {
            throw new IllegalArgumentException("Некоретное отчество");
        }
        // если у человека не указано отчество я сильно ему соболезную,
        // но проверку менять не стану
        this.surname = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0 || age>116) {
            throw new IllegalArgumentException("Некоректное значение возраста");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj;
        return age == human.age &&
                lastName.equals(human.lastName) &&
                firstName.equals(human.firstName) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, surname, age);
    }
}