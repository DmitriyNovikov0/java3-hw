package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class TestsInvoker {

    public void invokeTests(Class<?> c) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        ArrayList<Method> methods = new ArrayList<>();
        Method before = null, after = null;
        for (Method method : c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methods.add(method);
            }
            if (method.isAnnotationPresent(Before.class)) {
                before = method;
            }
            if (method.isAnnotationPresent(After.class)) {
                after = method;
            }
        }
        Object tests = c.getConstructor().newInstance();
        methods.sort(Comparator
                .comparingInt(value -> -value.getAnnotation(Test.class).priority()));
        if (before != null) {
            before.invoke(tests);
        }
        for (Method method : methods) {
            method.invoke(tests);
        }
        if (after != null) {
            after.invoke(tests);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Class<?> clazz = String.class;
        new TestsInvoker().invokeTests(clazz);
    }
}
