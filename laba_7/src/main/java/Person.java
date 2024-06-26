import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

class Person  {
    private String firstName;
    private String lastName;
    private String surName;
    private String dateOfBirth;


    public Person(String самый, String главный, String управдом, LocalDate parse){}
    public Person(String firstName, String lastName, String surName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return (this.firstName + " " + lastName + " " + surName);
    }

    public String getFio(){
        return (this.firstName +" "+ lastName.charAt(0) + "." + surName.charAt(0));
    }

    @JsonProperty("dateOfBirth")
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
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && surName.equals(person.surName) && dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, surName, dateOfBirth);
    }
}