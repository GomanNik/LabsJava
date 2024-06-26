import java.util.*;

public class CollectionsDemo {
    public static int countStringsStartingWithChar(List<String> strings,char symbol){
        if (!Character.isLetter(symbol)) {
            throw new IllegalArgumentException("Входной символ должен быть буквой!");
        }
        if (strings.isEmpty()) {
            throw new NullPointerException("Список должен быть не пуст");
        }

        int count = 0;

        for (String str : strings) {
            if (str.charAt(0) == symbol) {
                count++;
            }
        }

        return count;
    }

    public static List<Human> removeHuman(List<Human> humans, Human humanToRemove) {
        if (humans.isEmpty()  || humanToRemove == null) {
            throw new NullPointerException("Недопустимые значения параметров humans или humanToRemove!");
        }
        List<Human> copiedList = new ArrayList<>(humans);
        copiedList.remove(humanToRemove);
        return copiedList;
    }

    public static List<Set<Integer>> getNonIntersectingSets(List<Set<Integer>> inputList, Set<Integer> listOfDisjointSets){
        if (inputList.isEmpty() || listOfDisjointSets.isEmpty()) {
            throw new NullPointerException("Недопустимые значения параметров inputList или listOfDisjointSets!");
        }

        List<Set<Integer>> nonIntersectingSets = new ArrayList<>();

        for (Set<Integer> set : inputList) {

            boolean hasIntersection = false;

            for (int element : set) {
                if (listOfDisjointSets.contains(element)) {
                    hasIntersection = true;
                    break;
                }
            }
            if (!hasIntersection) {
                nonIntersectingSets.add(set);
            }
        }

        return nonIntersectingSets;
    }

    public static Set<Human> getPeopleWithIds(Map<Integer, Human> idToHuman, Set<Integer> idSet) {
        if (idToHuman.isEmpty() || idSet == null) {
            throw new NullPointerException("Недопустимые значения параметров idToHuman или idSet!");
        }

        Set<Human> result = new HashSet<>();
        for (int id : idSet) {
            Human human = idToHuman.get(id);
            if (human != null) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Integer> getIdsOfAdults(Map<Integer, Human> idToHuman) {
        if (idToHuman.isEmpty()) {
            throw new NullPointerException("idToHuman не может быть пустым!");
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Human> entry : idToHuman.entrySet()) {
            if (entry.getValue().getAge() >= 18) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static Map<Integer, Integer> getIdToAgeMap(Map<Integer, Human> idToHumanMap) {
        if (idToHumanMap.isEmpty()) {
            throw new NullPointerException("idToHumanMap не может быть пустым!");
        }
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Human> entry : idToHumanMap.entrySet()) {
            result.put(entry.getKey(), entry.getValue().getAge());
        }
        return result;
    }

    public static Map<Integer, List<Human>> getAgeToPeopleMap(Set<Human> humanSet) {
        if (humanSet.isEmpty()) {
            throw new NullPointerException("humanSet не может быть пустым!");
        }
        Map<Integer, List<Human>> result = new LinkedHashMap<>();
        for (Human human : humanSet) {
            int age = human.getAge();
            if (!result.containsKey(age)) {
                result.put(age, new ArrayList<>());
            }
            result.get(age).add(human);
        }
        return result;
    }
    public static List<? extends Human> getAlphabeticalList(Set<? extends Human> peoples) {

        TreeSet<Human> treeSet = new TreeSet<>(new ComparatorPeoples());

        treeSet.addAll(peoples);

        return new ArrayList<>(treeSet);
    }
    public static Map<Integer, Map<Character, List<Human>>> getAgeToAlphabeticalPeopleMap(Set<Human> humanSet) {

        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();

        for (Human human : humanSet) {
            int age = human.getAge();
            char firstLetter = human.getLastName().charAt(0);

            if (!result.containsKey(age)) {
                result.put(age, new HashMap<>());
            }

            Map<Character, List<Human>> letterToPeople = result.get(age);
            if (!letterToPeople.containsKey(firstLetter)) {
                letterToPeople.put(firstLetter, new ArrayList<>());
            }

            letterToPeople.get(firstLetter).add(human);
        }

        for (Map<Character, List<Human>> letterToPeople : result.values()) {

            for (List<Human> people : letterToPeople.values()) {
                people.sort(new ComparatorPeoples().reversed());
            }
        }

        return result;
    }
    

}