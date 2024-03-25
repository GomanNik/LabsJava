import java.util.*;
public class ListDemo {
    public static List<Human> getListWithSameLastName(List<Human> humans, Human person) {
        if (humans.isEmpty()  || person == null) {
            throw new NullPointerException("Недопустимые значения параметров humans или person!");
        }

        List<Human> sameLastNameList = new ArrayList<>();

        for (Human human : humans) {
            if (human.getLastName().equals(person.getLastName())) {
                sameLastNameList.add(human);
            }
        }

        return sameLastNameList;
    }
    public static Set<Human> getOldestPeople(List<? extends Human> humans) {
        if (humans.isEmpty()) {
            throw new NullPointerException("Недопустимое значения параметра!");
        }
        int maxAge = -1;
        Set<Human> result = new HashSet<>();
        for (Human human : humans) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
                result.clear();
                result.add(human);
            } else if (human.getAge() == maxAge) {
                result.add(human);
            }
        }
        return result;
    }

}