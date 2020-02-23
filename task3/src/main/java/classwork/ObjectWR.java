package classwork;

import java.io.*;

public class ObjectWR {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\Mikhail\\IdeaProjects\\Java31\\task3\\src\\main\\java\\classwork\\user.data");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user = (User) ois.readObject();
        System.out.println(user);

        //XML
        /*
        * <user name=Ivan, id=12/>
        * */
        //JSON
        /*
        * {"array": [1,2,3],"boolean": true,"color": "#82b92c","null": null,
        * "number": 123,
         "object": {"a": "b","c": "d","e": "f"},"string": "Hello World"}
        *
        * */
    }



    void objectWriter() throws IOException {
        User user = new User(12, "Ivan");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File("C:\\Users\\Mikhail\\IdeaProjects\\Java31\\task3\\src\\main\\java\\classwork\\user.data")));
        oos.writeObject(user);
    }
}
