package lesson3;

import java.io.*;
import java.util.TreeMap;
import java.util.stream.Stream;

public class WordStat {

    private File input;
    private TreeMap<String, Integer> map;

    public WordStat(File input) {
        this.input = input;
        map = new TreeMap<>();
    }

    public void makeStat() throws FileNotFoundException {
        new BufferedReader(new FileReader(input))
                .lines().map(x->x.split(" "))
                .forEach(x->{
                    for(String str : x){
                        map.put(str, map.getOrDefault(str, 0) + 1);
                    }
                });
    }

}
