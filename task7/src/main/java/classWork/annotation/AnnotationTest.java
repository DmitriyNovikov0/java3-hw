package classWork.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AnnotationTest {
    public static void main(String[] args) {
        Class<?> c = MyClass.class;
        ArrayList<Method> methods = new ArrayList<>();
        for (Method method : c.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RuntimeAnnotation.class)) {
                methods.add(method);
            }
        }
        System.out.println(methods);
        System.out.println(methods.get(0)
                .getAnnotation(RuntimeAnnotation.class).mark() + " " +
                methods.get(0)
                        .getAnnotation(RuntimeAnnotation.class).value());

    }
}
