package classWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuncTools {

    interface Function {
        void apply(Argument arg);
    }

    interface BinaryFunction {
        void apply(Argument left, Argument right);
    }

    static class Argument {

        int value;

        void apply(Function func) {
            func.apply(this);
        }

        void apply(BinaryFunction func) {
            //this.apply(func);
        }
    }

    static String path = "C:\\Users\\Mikhail\\IdeaProjects\\Java31\\task8\\src\\main\\java\\classWork\\data.txt";
    public static void main(String[] args) throws FileNotFoundException {
        /*Stream<String> stream = */
        Argument argg = new Argument(); argg.value = 12;
        argg.apply((x, y) -> {
            argg.value = x.value + y.value;
        });
        argg.apply(param ->  param.value += 5);
        System.out.println(argg.value);
        List<String> list = new BufferedReader(
                new FileReader(new File(path)))
                .lines()
                .map(arg -> arg.replaceAll("j", "aa"))
                .flatMap(arg -> Stream.of(arg.split(" ")))
                .filter(arg -> !arg.isEmpty() && arg.length() > 1)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
