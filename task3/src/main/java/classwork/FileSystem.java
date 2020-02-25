import classwork.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileSystem {

    static String pathToResource = "H:\\Java 3\\leson2 hw\\task3\\src\\main\\resources\\";

    public static void main(String[] args) throws IOException {
/*
        //System.out.println(Arrays.toString(File.listRoots()));
        File file = new File(path + "1.txt");
        File p = new File(path);
        //p.mkdir();
        System.out.println(p.isDirectory());
        //System.out.println(p.getParentFile());
        //System.out.println(Arrays.toString(p.listFiles()));
        File parent = p;
        while (parent != null) {
            //System.out.println(parent);
            parent = parent.getParentFile();
        }
        dfs(new File("E:\\"), "", 3);
*/
        List<String> list = new ArrayList();
        for(int i = 0; i <= 10; i++){
            list.add(String.valueOf(i));
        }

        FileUtility fu = new FileUtility();
        fu.sortEvenElements(new File(pathToResource +"//array.txt"), new File(pathToResource + "//pass.txt"));
        fu.passwordGen(new File(pathToResource +"//login.txt"), new File(pathToResource + "//pass.txt"));
//        fu.appender(new File(pathToResource +"//append.txt"), list);
        fu.getNString(pathToResource +"//file.txt" , 4);
        list.clear();
        list = fu.getNString(pathToResource +"//file.txt" , 4);
    }

    static void writeUser(File file, User user) throws IOException {
        return;
    }

    static User readUser(File file) throws IOException, ClassNotFoundException {
        return null;
    }

    static void writeData(File file, boolean append) throws IOException {

    }

    static void printFileData(File file) throws FileNotFoundException {

    }

    static void createPaths(File file) throws IOException {

    }

    static void dfs(File file, String depth, int d){
        if (d == 0) return;
        if (file != null) {
            System.out.println(depth + file);
            if (file.isDirectory()) {
                File [] files = file.listFiles();
                if (files != null) {
                    for(File f : files) {
                        dfs(f, depth + "-", d-1);
                    }
                }
            }
        }
    }
}
