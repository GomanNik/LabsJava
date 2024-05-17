import java.util.function.Function;

public class LambdaDemo {

    public static final Function<String, Integer> getLength = String::length;

    public static final Function<String, Character> getFirstChar = s -> s.isEmpty() ? null : s.charAt(0);

    public static final Function<String, Boolean> containsNoSpaces = s -> !s.contains(" ");

    public static final Function<String, Integer> countWords = s -> s.split(",").length;

    public static final Function<Human, Integer> getAge = Human::getAge;

    public static final Function<Human, Function<Human, Boolean>> checkSameLastName = person1 -> person2 -> person1.getLastName().equals(person2.getLastName());

    public static final Function<Human, String> getFullName = h -> h.getLastName() + " " + h.getFirstName() + " " + h.getSurname();

    public static final Function<Human, Human> makeOneYearOlder = h -> new Human(h.getFirstName(), h.getLastName(), h.getSurname(), h.getAge() + 1, h.getGender());

    public static final Function<Integer, Function<Human[],Boolean>> checkIfAllYoungerThan = maxAge -> humans -> humans.length == 3 && humans[0].getAge() < maxAge && humans[1].getAge() < maxAge && humans[2].getAge() < maxAge;

}