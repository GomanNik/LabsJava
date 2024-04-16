import java.util.Objects;

public class Human {
    private String lastName;
    private String firstName;
    private String surName;
    private int age;
    private Gender gender;

    public Human(String lastName, String firstName, String surName, int age, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurname(String middleName) {
        this.surName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                lastName.equals(human.lastName) &&
                firstName.equals(human.firstName) &&
                surName.equals(human.surName) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, surName, age, gender);
    }
}

// Перечисление Gender
enum Gender {
    MALE,
    FEMALE
}