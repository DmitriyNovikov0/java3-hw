package classWork;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class Ex2 {

    public static void main(String[] args) {
        User.LocalClass cl = new User()
                .new LocalClass();

        List<Integer> l = Collections
                .unmodifiableList(Arrays.asList(1,23,4));
        //Stream API
        l.stream().map(x-> x + 3)
                  .sorted()
                  .filter(x-> x >= 4)
                  .forEach(System.out::println);

    }
}
