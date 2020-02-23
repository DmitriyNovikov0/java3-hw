package classWork;

import java.util.*;

public class Ex1 implements Cloneable{

    static class Node {

        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return a == node.a &&
                    b == node.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        //hash(obj) = целое число
        //для разных объектов хеши по возможности
        //должны быть разными
        //для одинаковых объектов хеши обязаны
        //быть одинаковыми
        //объект а и объект б одинаковы тогда, когда
        //если а = б то б = а
        String s1 = "aaba";
        String s2 = "aabb";
        //'a'*1 + 'a'*31 + 'b'*31^2 + 'a'*31^3
        Node n1 = new Node(1,2);
        Node n2 = new Node(1, 2);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n1.equals(n2));
        //HashMap - ?
        //Collection
        //Map is Collection?
        //SOLID
        //Почему коллекции не
        //реализуют cloneable serializable
        Map map = new HashMap();
        map.put(null, 2);
        map.put(User.class, 15);
        map.put(new NullPointerException(), 10);
        System.out.println(map);
    }
}
