package lesson3;

import java.io.*;

public class ObjectWriter {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat = new Cat("Vaska", 5, true);
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("out.txt"));
        oos.writeObject(cat);
        ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream("out.txt"));
        Cat cat1 = (Cat) ois.readObject();
        System.out.println(cat1);
    }
}
