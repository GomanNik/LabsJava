import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    public static int countHumanTypes(List<Object> objects) {
        int count = 0;
        for (Object obj : objects) {
            if (obj instanceof Human) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getPublicMethodNames(Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj не может быть пустым");
        }
        Method[] methods = obj.getClass().getMethods();
        List<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }

    public static List<String> getSuperClassNames(Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj не может быть пустым");
        }
        List<String> superClassNames = new ArrayList<>();
        Class<?> currentClass = obj.getClass().getSuperclass();
        while (currentClass != null) {
            superClassNames.add(currentClass.getName());
            currentClass = currentClass.getSuperclass();
        }
        return superClassNames;
    }
}