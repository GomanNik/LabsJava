import java.util.Comparator;

public class ComparatorPeoples extends Human implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {

        int lastNameCompare = human1.getLastName().compareTo(human2.getLastName());
        if (lastNameCompare != 0 ) return lastNameCompare;

        int firstNameCompare = human1.getFirstName().compareTo(human2.getFirstName());
        if (firstNameCompare != 0 ) return firstNameCompare;

        int surnameCompare = human1.getSurname().compareTo(human2.getSurname());
        if (surnameCompare != 0 ) return surnameCompare;

        return 0;
    }
}
