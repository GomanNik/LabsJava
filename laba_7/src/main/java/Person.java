import java.io.*;
import java.util.Objects;

class Person extends Human {
    private String dateOfBirth;

    public Person(String firstName, String lastName, String middleName, String dateOfBirth) {

        super(lastName, firstName, Surname, age);
        this.dateOfBirth = dateOfBirth;
    }



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && middleName.equals(person.middleName) && dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, dateOfBirth);
    }
}