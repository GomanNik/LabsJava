import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class StreamApiDemoTest {

    @Test
    public void testRemoveNulls() {
        List<Object> listWithNulls = Arrays.asList(1, null, 3, null, 5);
        List<Object> listWithoutNulls = Arrays.asList(1, 3, 5);

        assertEquals(listWithoutNulls, LambdaRunner.runUnaryOperator(StreamApiDemo.removeNulls, listWithNulls));

    }
    @Test
    public void testRemoveNullsElem() {
        List<Object> listWithNulls = Arrays.asList(null, null, null);
        List<Object> listWithoutNulls = Collections.emptyList();

        assertEquals(listWithoutNulls, LambdaRunner.runUnaryOperator(StreamApiDemo.removeNulls, listWithNulls));
    }

    @Test
    public void testCountPositiveIntegers() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(-1);
        numbers.add(2);
        numbers.add(3);

        assertEquals(2, LambdaRunner.runFunction(StreamApiDemo.countPositiveIntegers, numbers));
    }
    @Test
    public void testCountPositiveIntegers_negative(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(-1);
        numbers.add(-2);
        numbers.add(-3);

        assertEquals(0, LambdaRunner.runFunction(StreamApiDemo.countPositiveIntegers, numbers));
    }

    @Test
    public void testGetLastThreeElements() {
        List<Object> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Object> lastThree = Arrays.asList(3, 4, 5);

        assertEquals(lastThree, LambdaRunner.runUnaryOperator(StreamApiDemo.getLastThreeElements, numbers));
    }
    @Test
    public void testGetThreeLastElements_negative(){
        Human human = new Human("John", "Doe", "Smith", 30, Gender.MALE);

        List<Object> numbers = Arrays.asList("белка",2,human,false);
        List<Object> lastThree = Arrays.asList(2,human,false);

        assertEquals(lastThree, LambdaRunner.runUnaryOperator(StreamApiDemo.getLastThreeElements, numbers));
    }

    @Test
    public void testGetFirstEvenOrNull() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(2, LambdaRunner.runFunction(StreamApiDemo.getFirstEvenOrNull, numbers));

    }
    @Test
    public void testGetFirstEvenOrNull_negative(){
        List<Integer> numbers = Arrays.asList(7, 9, 11);

        assertNull(LambdaRunner.runFunction(StreamApiDemo.getFirstEvenOrNull, numbers));
    }
    @Test
    public void testGetSquaresWithoutDuplicatesFirst() {
        int[] array = {1, 2, 2, 3};
        List<Integer> expected = Arrays.asList(1, 4, 9);

        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.getSquaresWithoutDuplicates, array));
    }
    @Test
    public void testGetSquaresWithoutDuplicatesSecond(){
        int[] array = new int[]{-1, 0, 1, 1};
        List<Integer> expected = Arrays.asList(1,0);

        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.getSquaresWithoutDuplicates, array));
    }

    @Test
    public void testGetSortedNonEmptyStrings() {
        List<String> list = Arrays.asList("apple", "", "carrot", "banana", "");
        List<String> expected = Arrays.asList("apple", "banana", "carrot");

        assertEquals(expected, LambdaRunner.runUnaryOperator(StreamApiDemo.getSortedNonEmptyStrings, list));


    }
    @Test
    public void testGetSortedNonEmptyStrings_negative() {
        List<String> list = Arrays.asList("", "", "");
        List<String> expected = Collections.emptyList();

        assertEquals(expected, LambdaRunner.runUnaryOperator(StreamApiDemo.getSortedNonEmptyStrings, list));
    }

    @Test
    public void testSortedSetDescending() {
        Set<String> set = new LinkedHashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("carrot");

        List<String> expected = Arrays.asList("carrot", "banana", "apple");

        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.sortedSetDescending, set));
    }
    @Test
    public void testSortedSetDescending_negative(){
        Set<String>set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        List<String> expected = Arrays.asList("c", "b", "a");

        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.sortedSetDescending, set));
    }

    @Test
    public void testSumOfSquaredIntegers() {
        Set<Integer>set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Integer expected = 14; // 1^2 + 2^2 + 3^2 = 1 + 4 + 9 = 14

        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.sumOfSquaredIntegers, set));
    }
    @Test
    public void testSumOfSquaredIntegers_negative() {
        Set<Integer>set = new HashSet<>();
        set.add(-1);
        set.add(-2);
        set.add(-3);
        Integer expected = 14; // (-1)^2 + (-2)^2 + (-3)^2 = 1 + 4 + 9 = 14
        assertEquals(expected, LambdaRunner.runFunction(StreamApiDemo.sumOfSquaredIntegers, set));
    }
    @Test
    public void testMaxAgeOfPersons() {
        List<Human> persons = Arrays.asList(new Human("Иванов", "Иван", "Иванович", 30, Gender.FEMALE),
                new Human("Петров", "Петр", "Петрович", 45, Gender.MALE),
                new Human("Сидоров", "Сидор", "Сидорович", 25, Gender.MALE),
                new Student("Студентов", "Студент", "Студентович", 20, Gender.MALE,"University","Faculty","Specialty"));

        assertEquals(45, LambdaRunner.runFunction(StreamApiDemo.maxAgeOfPersons, persons));
    }
    @Test
    public void testMaxAgeOfPerson() {
        List<Human> persons = Arrays.asList(new Human("Давыдов", "Давид", "Давидович", 22, Gender.MALE),
                new Human("Евгеньева", "Евгения", "Евгеньевна", 29, Gender.FEMALE),
                new Student("Студентов", "Студент", "Студентович", 20, Gender.MALE,"University","Faculty","Specialty"));

        assertEquals(29, LambdaRunner.runFunction(StreamApiDemo.maxAgeOfPersons, persons));
    }

    @Test
    public void testSortPersonsByGenderAndAgeFirst() {
        List<Human> persons = Arrays.asList(new Human("Иванова", "Алиса", "Ивановна", 30, Gender.FEMALE),
                new Human("Петров", "Петр", "Петрович", 45, Gender.MALE),
                new Human("Сидоров", "Сидор", "Сидорович", 25, Gender.MALE),
                new Student("Студентов", "Студент", "Студентович", 20, Gender.MALE,"University","Faculty","Specialty"),
                new Human("Евгеньева", "Евгения", "Евгеньевна", 29, Gender.FEMALE));

        List<Human> expectedSorted = Arrays.asList(
                new Student("Студентов", "Студент", "Студентович", 20, Gender.MALE,"University","Faculty","Specialty"),
                new Human("Сидоров", "Сидор", "Сидорович", 25, Gender.MALE),
                new Human("Петров", "Петр", "Петрович", 45, Gender.MALE),
                new Human("Евгеньева", "Евгения", "Евгеньевна", 29, Gender.FEMALE),
                new Human("Иванова", "Алиса", "Ивановна", 30, Gender.FEMALE));

        assertEquals(expectedSorted, LambdaRunner.runUnaryOperator(StreamApiDemo.sortPersonsByGenderAndAge, persons));
    }
    @Test
    public void testSortPersonsByGenderAndAgeSecond()
    {
        List<Human> persons = Arrays.asList(new Human("Давыдов", "Давид", "Давидович", 22, Gender.MALE),
                new Human("Евгеньева", "Евгения", "Евгеньевна", 29, Gender.FEMALE),
                new Human("Франков", "Франк", "Франкович", 29, Gender.MALE));

        List<Human> expectedSorted = Arrays.asList(
                new Human("Давыдов", "Давид", "Давидович", 22, Gender.MALE),
                new Human("Франков", "Франк", "Франкович", 29, Gender.MALE),
                new Human("Евгеньева", "Евгения", "Евгеньевна", 29, Gender.FEMALE));

        assertEquals(expectedSorted, LambdaRunner.runUnaryOperator(StreamApiDemo.sortPersonsByGenderAndAge, persons));
    }

}