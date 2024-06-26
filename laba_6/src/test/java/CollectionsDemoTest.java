import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class CollectionsDemoTest {
    @Test
    void countStringsStartingWithCharATest() {
        List<String> namesOfFruits = Arrays.asList("яблоко","банан","Абрикос","апельсин");

        assertEquals(1,CollectionsDemo.countStringsStartingWithChar(namesOfFruits,'а'));
    }
    @Test
    void countStringsWithCharTest(){
        List<String> strings = Arrays.asList("Я помню чудное мгновение","Я с тобой на всегда","Парарам");
        assertEquals(2,CollectionsDemo.countStringsStartingWithChar(strings,'Я'));
    }
    @Test
    void countStringsStartingWithCharTestWithNegative() {
        List<String> namesOfFruits = Arrays.asList("яблоко","банан","Абрикос","апельсин");
        assertThrows(IllegalArgumentException.class, () -> CollectionsDemo.countStringsStartingWithChar(namesOfFruits,'#'));
        assertThrows(NullPointerException.class, () -> CollectionsDemo.countStringsStartingWithChar(null,'a'));
    }
    @Test
    void removeHumanTest() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Human personThird = new Human("Лермонтов  ","Михаил","Юрьевич",28);
        List<Human> humans = Arrays.asList(personFirst,personSecond,personThird);
        List<Human> humansNext = Arrays.asList(personFirst,personThird);

        assertEquals(humansNext,CollectionsDemo.removeHuman(humans,personSecond));
    }
    @Test
    void removeHumanTestWithNegative() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Human personThird = new Human("Лермонтов  ","Михаил","Юрьевич",28);
        List<Human> humans = Arrays.asList(personFirst,personSecond,personThird);

        assertThrows(NullPointerException.class, () -> CollectionsDemo.removeHuman(humans,null));
        assertThrows(NullPointerException.class, () -> CollectionsDemo.removeHuman(null,personFirst));
    }
    @Test
    void getNonIntersectingSetsTest() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        Set<Integer> set2 = new HashSet<>();
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        Set<Integer> set3 = new HashSet<>();
        set3.add(9);
        set3.add(10);
        set3.add(5);
        set3.add(7);

        List<Set<Integer>> list = Arrays.asList(set1,set2);
        List<Set<Integer>> nextList = Arrays.asList(set1);
        assertEquals(nextList,CollectionsDemo.getNonIntersectingSets(list,set3));

    }
    @Test
    void getNonIntersectingSetsWithNegativeTest() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        List<Set<Integer>> list = Arrays.asList(set1,set2);

        assertThrows(NullPointerException.class, () -> CollectionsDemo.getNonIntersectingSets(null,set2));
        assertThrows(NullPointerException.class, () -> CollectionsDemo.getNonIntersectingSets(list,null));
    }

    @Test
    public void getPeopleWithIdsTest() {
        Map<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(1, new Human("Пушкин", "Александр", "Сергеевич", 38));
        peopleMap.put(2, new Human("Толстой","Лев","Николаевич",40));

        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(3);

        Set<Human> result = new HashSet<>();
        result.add(new Human("Пушкин", "Александр", "Сергеевич", 38));

        assertEquals(CollectionsDemo.getPeopleWithIds(peopleMap, ids),result);
    }

    @Test
    public void getPeopleWithIdsWithNegativeTest() {
        Map<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(1, new Human("Пушкин", "Александр", "Сергеевич", 38));
        peopleMap.put(2, new Human("Толстой","Лев","Николаевич",17));
        peopleMap.put(3, new Human("Лермонтов  ","Михаил","Юрьевич",15));

        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(3);

        assertThrows(NullPointerException.class, () -> CollectionsDemo.getPeopleWithIds(null,ids));
        assertThrows(NullPointerException.class, () -> CollectionsDemo.getPeopleWithIds(peopleMap,null));
    }
    @Test
    public void getIdsOfAdultsTest() {
        Map<Integer, Human> peopleMap = new HashMap<>();
        peopleMap.put(1, new Human("Пушкин", "Александр", "Сергеевич", 38));
        peopleMap.put(11, new Human("Пушкин", "Александр", "Сергеевич", 38));
        peopleMap.put(2, new Human("Толстой","Лев","Николаевич",17));
        peopleMap.put(3, new Human("Лермонтов  ","Михаил","Юрьевич",15));

        List<Integer> result = Arrays.asList(1, 11);

        assertEquals(CollectionsDemo.getIdsOfAdults(peopleMap),result);
    }
    @Test
    public void getIdsOfAdultsWithNegativeTest() {
       assertThrows(NullPointerException.class, () -> CollectionsDemo.getIdsOfAdults(null));
    }

    @Test
    public void getIdToAgeMapTest() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Human personThird = new Human("Лермонтов  ","Михаил","Юрьевич",28);
        Map<Integer, Human> humans = new HashMap<>();
        humans.put(1,personFirst);
        humans.put(2,personSecond);
        humans.put(3,personThird);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 38);
        expected.put(2, 40);
        expected.put(3, 28);

        assertEquals(expected,CollectionsDemo.getIdToAgeMap(humans));
    }
    @Test
    public void getAgeToPeopleMapTest() {

        Set<Human> humans = new LinkedHashSet<>();
        humans.add(new Human("Пушкин","Александр","Сергеевич",38));
        humans.add(new Human("Толстой","Лев","Николаевич",40));
        humans.add(new Human("Иванов","Михаил","Юрьевич",28));
        humans.add(new Human("Петров","Михаил","Юрьевич",28));

        Map<Integer, List<Human>> result = new LinkedHashMap<>();
        result.put(38,Arrays.asList(new Human("Пушкин","Александр","Сергеевич",38)));
        result.put(40,Arrays.asList(new Human("Толстой","Лев","Николаевич",40)));
        result.put(28,Arrays.asList(
                new Human("Иванов","Михаил","Юрьевич",28),
                new Human("Петров","Михаил","Юрьевич",28)
                ));

        assertEquals(result,CollectionsDemo.getAgeToPeopleMap(humans));
    }
    @Test
    public void getAlphabeticalList(){
        TreeSet<Human> humans = new TreeSet<>();
        humans.add(new Human("Пушкин","Александр","Сергеевич",38));
        humans.add(new Human("Толстой","Лев","Николаевич",40));
        humans.add(new Human("Иванов","Михаил","Юрьевич",28));
        humans.add(new Human("Петров","Михаил","Юрьевич",28));

        List<Human> expected = Arrays.asList(
                        new Human("Иванов","Михаил","Юрьевич",28),
                        new Human("Петров","Михаил","Юрьевич",28),
                        new Human("Пушкин","Александр","Сергеевич",38),
                        new Human("Толстой","Лев","Николаевич",40));

        assertEquals(expected,CollectionsDemo.getAlphabeticalList(humans));
    }
    @Test
    public void getAlphabeticalListSecond(){
        HashSet<Human> humans = new HashSet<>();
        humans.add(new Human("Абвгдеёж","Михаил","Юрьевич",28));
        humans.add(new Human("Абвгдеёж","Анастасия","Алексеевна",28));
        humans.add(new Student("Абвгдеёж","Александр","Юрьевич",28,"faculty"));
        humans.add(new Human("Абвгдеёж","Михаил","Дмитриевич",28));

        List<? extends Human> expected = Arrays.asList(
                new Student("Абвгдеёж","Александр","Юрьевич",28,"faculty"),
                new Human("Абвгдеёж","Анастасия","Алексеевна",28),
                new Human("Абвгдеёж","Михаил","Дмитриевич",28),
                new Human("Абвгдеёж","Михаил","Юрьевич",28));

        assertEquals(expected,CollectionsDemo.getAlphabeticalList(humans));
    }

    @Test
    public void getIdToAgeMapWithNegativeTest() {
        assertThrows(NullPointerException.class, () -> CollectionsDemo.getIdToAgeMap(null));
    }

    @Test
    public void getAgeToPeopleMapWithNegativeTest() {
        assertThrows(NullPointerException.class, () -> CollectionsDemo.getAgeToPeopleMap(null));
    }

    @Test
    public void getAgeToAlphabeticalPeopleMapTestFirst() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",38);
        Human personSecond = new Human("Толстой","Лев","Николаевич",40);
        Human personThird = new Human("Лермонтов  ","Михаил","Юрьевич",28);
        Student student = new Student("Пушкин","Антон","Константинович",38,"SPO");
        Set<Human> humanSet = new HashSet<>();
        humanSet.add(personFirst);
        humanSet.add(personSecond);
        humanSet.add(personThird);
        humanSet.add(student);

        Map<Integer, Map<Character, List<Human>>> result = CollectionsDemo.getAgeToAlphabeticalPeopleMap(humanSet);
        Map<Integer, Map<Character, List<Human>>> expected =new LinkedHashMap<>();
        expected.put(38, new LinkedHashMap<>());
        expected.get(38).put('П', new ArrayList<>());
        expected.get(38).get('П').add(personFirst);
        expected.get(38).get('П').add(student);

        expected.put(40, new LinkedHashMap<>());
        expected.get(40).put('Т', new ArrayList<>());
        expected.get(40).get('Т').add(personSecond);

        expected.put(28, new LinkedHashMap<>());
        expected.get(28).put('Л', new ArrayList<>());
        expected.get(28).get('Л').add(personThird);
        for (Map<Character, List<Human>> letterToPeople : expected.values()) {
            for (List<Human> people : letterToPeople.values()) {
                people.sort(new ComparatorPeoples().reversed());
            }
        }

        assertEquals(expected, result);
    }
    @Test
    public void getAgeToAlphabeticalPeopleMapTestWithEmptySetException() {
        assertThrows(NullPointerException.class, () -> CollectionsDemo.getAgeToAlphabeticalPeopleMap(null));
    }

    @Test
    public void getAgeToAlphabeticalPeopleMapTest() {
        Human personFirst = new Human("Пушкин","Александр","Сергеевич",37);
        Human personSecond = new Student("Партос","Мушкетёр","Мушкетёрович",37,"Факультет Реконструкции");
        //37- летний студент Партос, ну и что!)
        Human personThird = new Human("Пелагея   ","Сергеевна ","Телегина",37);
        Student student = new Student("Емельянов","Антон","Константинович",37,"SPO");

        Set<Human> humanSet = new HashSet<>();
        humanSet.add(personFirst);
        humanSet.add(personSecond);
        humanSet.add(personThird);
        humanSet.add(student);

        Map<Integer, Map<Character, List<Human>>> result = CollectionsDemo.getAgeToAlphabeticalPeopleMap(humanSet);

        Map<Integer, Map<Character, List<Human>>> expected = new HashMap<>();
        expected.put(37, new HashMap<>());
        expected.get(37).put('П', new ArrayList<>());
        expected.get(37).put('Е',new ArrayList<>());


        expected.get(37).get('П').add(personFirst);
        expected.get(37).get('П').add(personSecond);
        expected.get(37).get('П').add(personThird);

        expected.get(37).get('Е').add(student);

        for (List<Human> people : expected.get(37).values()) {
            people.sort(new ComparatorPeoples().reversed());
        }

        assertEquals(expected, result);


    }
}

