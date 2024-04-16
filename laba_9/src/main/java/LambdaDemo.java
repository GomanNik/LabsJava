import java.util.function.Function;

public class LambdaDemo {

    public static final Function<String, Integer> getLength = String::length;

    public static final Function<String, Character> getFirstChar = s -> s.isEmpty() ? null : s.charAt(0);

    public static final Function<String, Boolean> containsNoSpaces = s -> !s.contains(" ");

    public static final Function<String, Integer> countWords = s -> s.split(",").length;

    public static final Function<Human, Integer> getAge = Human::getAge;

    public static final Function<Human, Boolean> hasSameLastName = h -> h.getLastName().equals(h.getLastName());

    public static final Function<Human, String> getFullName = h -> h.getLastName() + " " + h.getFirstName() + " " + h.getSurname();

    public static final Function<Human, Human> makeOneYearOlder = h -> new Human(h.getFirstName(), h.getLastName(), h.getSurname(), h.getAge() + 1, h.getGender());

    public static final Function<Integer, Function<Human, Function<Human, Function<Human, Boolean>>>> checkIfAllYoungerThan = maxAge -> h1 -> h2 -> h3 -> h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
}