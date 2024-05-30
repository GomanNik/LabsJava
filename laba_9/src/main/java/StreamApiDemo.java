import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamApiDemo extends LambdaDemo {

    //        1) в списке объектов удалить все значения null,
    public static final UnaryOperator<List<Object>> removeNulls = list ->
            list.stream().filter(Objects::nonNull).collect(Collectors.toList());

    //       2) во множестве целых чисел найти количество положительных значений,
    public static final Function<Set<Integer>, Long> countPositiveIntegers = set ->
            set.stream().filter(num -> num > 0).count();

    //        3) в списке объектов получить последние три элемента,
    public static final UnaryOperator<List<Object>> getLastThreeElements = list ->
            list.stream().skip(Math.max(0, list.size() - 3)).collect(Collectors.toList());

    //        4) в списке целых чисел получить первое четное число или значение null, если в списке
    //        нет четных чисел,
    public static final Function<List<Integer>, Integer> getFirstEvenOrNull = list ->
            list.stream().filter(num -> num % 2 == 0).findFirst().orElse(null);

    //        5) по массиву целых чисел построить список квадратов элементов массива без
    //        повторений,
    public static final Function<int[], List<Integer>> getSquaresWithoutDuplicates = array ->
            Arrays.stream(array).map(num -> num * num).distinct().boxed().collect(Collectors.toList());

    //        6) по списку строк построить новый список, содержащий все непустые строки исходного
    //        списка, упорядоченные по возрастанию,
    public static final UnaryOperator<List<String>> getSortedNonEmptyStrings = list ->
            list.stream().filter(str -> !str.isEmpty()).sorted().collect(Collectors.toList());

    //        7) множество строк превратить в список, упорядоченный по убыванию,
    public static final Function<Set<String>, List<String>> sortedSetDescending = set ->
            set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    //        8) для множества целых чисел вычислить сумму квадратов его элементов,
    public static final Function<Set<Integer>, Integer> sumOfSquaredIntegers = set ->
            set.stream().mapToInt(num -> num * num).sum();

    //        9) в коллекции людей вычислите максимальный возраст человека,
    public static final Function<List<Human>, Integer> maxAgeOfPersons = persons ->
            persons.stream().map(Human::getAge).max(Integer::compareTo).orElse(0);

//        10) отсортируйте коллекцию людей сперва по полу, затем — по возрасту
    public static final UnaryOperator<List<Human>> sortPersonsByGenderAndAge = persons ->
            persons.stream().sorted(Comparator.comparing(Human::getGender).thenComparing(Human::getAge))
                    .collect(Collectors.toList());
}