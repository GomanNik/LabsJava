import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamApiDemo extends LambdaDemo {

    public static final Function<List<Object>, List<Object>> removeNulls = list ->
            list.stream().filter(Objects::nonNull).collect(Collectors.toList());

    public static final Function<Set<Integer>, Long> countPositiveIntegers = set ->
            set.stream().filter(num -> num > 0).count();

    public static final Function<List<Object>, List<Object>> getLastThreeElements = list ->
            list.stream().skip(Math.max(0, list.size() - 3)).collect(Collectors.toList());

    public static final Function<List<Integer>, Integer> getFirstEvenOrNull = list ->
            list.stream().filter(num -> num % 2 == 0).findFirst().orElse(null);

    public static final Function<int[], List<Integer>> getSquaresWithoutDuplicates = array ->
            Arrays.stream(array).map(num -> num * num).distinct().boxed().collect(Collectors.toList());

    public static final Function<List<String>, List<String>> getSortedNonEmptyStrings = list ->
            list.stream().filter(str -> !str.isEmpty()).sorted().collect(Collectors.toList());

    public static final Function<Set<String>, List<String>> sortedSetDescending = set ->
            set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    public static final Function<Set<Integer>, Integer> sumOfSquaredIntegers = set ->
            set.stream().mapToInt(num -> num * num).sum();

    public static final Function<List<Human>, Integer> maxAgeOfPersons = persons ->
            persons.stream().map(Human::getAge).max(Integer::compareTo).orElse(0);

    public static final Function<List<Human>, List<Human>> sortPersonsByGenderAndAge = persons ->
            persons.stream().sorted(Comparator.comparing(Human::getGender).thenComparing(Human::getAge))
                    .collect(Collectors.toList());
}