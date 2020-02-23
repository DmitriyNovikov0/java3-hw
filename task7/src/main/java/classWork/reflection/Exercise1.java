package classWork.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise1 {
    // Reflection API
    // Fields, Methods, Constructors

    static void setCharAt(String str, char sym, int pos) throws NoSuchFieldException, IllegalAccessException {
        Class<?> c = String.class;
        Field chars = c.getDeclaredField("value");
        chars.setAccessible(true);
        char [] value = (char[]) chars.get(str);
        //System.out.println(value);
        value[pos] = sym;
        //System.out.println(value);
    }

    void lol(Object... objects){

    }

    static void invoke(String str, String other) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //m.invoke()
        Class<?> c = str.getClass();
        Method m = c.getMethod("compareTo", String.class);
        System.out.println(m.invoke(str, other));
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = String.class;
//        for (Field field : c.getDeclaredFields()) {
//            System.out.println(field);
//        }
        //String s = "abba";
        //setCharAt(s, 'z', 2);
        //System.out.println(s);
//        for (Method method : c.getMethods()) {
//            System.out.println(method);
//        }
        invoke("aabc", "aabaaaa");
    }
}
