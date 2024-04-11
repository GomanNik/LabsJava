import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    @Test
    void countHumanTypesWithOnlyHumansTest() {
        List<Object> objects = new ArrayList<>();
        objects.add(new Human("Иванов","Иван","Иванович",30));
        objects.add(new Worker("Работников","Дмитрий","Дмитриевич",22,"Програмист Питоняша"));
        objects.add(new Student("Колесников","Денис","Борисович",17,"Филология"));
        assertEquals(3,ReflectionDemo.countHumanTypes(objects));
    }
    @Test
    void countHumanTypesWithNegativeTest() {
        assertThrows(NullPointerException.class,()-> ReflectionDemo.countHumanTypes(null));
    }
    @Test
    void countHumanTypesWithDifferentFirstTest(){
        List<Object> objects = new ArrayList<>();
        objects.add("Тестовая строка");
        objects.add(3);
        objects.add(new Human("Иванов","Иван","Иванович",30));

        assertEquals(1,ReflectionDemo.countHumanTypes(objects));
    }
    @Test
    void countHumanTypesWithDifferentSecondTest(){
        List<Object> objects = new ArrayList<>();
        objects.add("Human");
        objects.add("Human");
        objects.add("Human");
        objects.add('r');
        objects.add(1.111111);
        assertEquals(0,ReflectionDemo.countHumanTypes(objects));
    }
    @Test
    void countHumanTypesWithDifferentThirdTest() {
        List<Object> objects = new ArrayList<>();
        objects.add(new Human("Иванов","Иван","Иванович",30));
        objects.add(new Worker("Работников","Дмитрий","Дмитриевич",22,"Програмист Питоняша"));
        objects.add(" fff");
        objects.add(111);
        assertEquals(2,ReflectionDemo.countHumanTypes(objects));
    }

    @Test
    void getPublicMethodNamesFirst() {
        List<String> actual = ReflectionDemo.getPublicMethodNames(
                new Human("Иванов","Иван","Иванович",30));
        List<String> expected = Arrays.asList(
                "equals", "hashCode", "getLastName", "getFirstName", "getSurname", "setAge", "setLastName", "setSurname", "setFirstName", "getAge", "toString", "getClass", "notify", "notifyAll", "wait", "wait", "wait");
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected,actual);
    }
    @Test
    void getPublicMethodNamesSecond() {
        Iterator<Integer> iterator = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
        List<String> actual = ReflectionDemo.getPublicMethodNames(iterator);
        for (String str: actual) System.out.println();
    }
    @Test
    public void testGetPublicMethodNamesNullObject() {
        assertThrows(NullPointerException.class,()->ReflectionDemo.getPublicMethodNames(null));
    }

    @Test
    void getSuperClassNamesArrayList() {
        List<String> superClassNames = ReflectionDemo.getSuperClassNames(new ArrayList<>());
        List<String> testArrayList = Arrays.asList(
                "java.util.AbstractList","java.util.AbstractCollection","java.lang.Object");
        assertEquals(testArrayList,superClassNames);
    }
    @Test
    void getSuperClassNamesHuman() {
        Worker worker = new Worker("Работников","Дмитрий","Дмитриевич",22,"Програмист Питоняша");

        List<String> superClassNames = ReflectionDemo.getSuperClassNames(worker);
        List<String> testWorker = Arrays.asList("Human","java.lang.Object");

        assertEquals(testWorker,superClassNames);
    }
    @Test
    void getSuperClassNamesWithNull() {
        assertThrows(NullPointerException.class,()-> ReflectionDemo.getSuperClassNames(null));
    }
}