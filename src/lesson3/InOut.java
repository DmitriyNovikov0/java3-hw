package lesson3;

import com.sun.media.sound.ModelStandardTransform;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class InOut {

    public static void main(String[] args) throws IOException, URISyntaxException {
        FileOutputStream fos = new FileOutputStream(new File("out.txt"), true);
        try(PrintWriter pr = new PrintWriter(fos)) {
            for (int i = 0; i < 10; i++) {
                pr.print(i);
            }
            pr.println();
        }
    }

    static void deepSearch(File file, String str){
        if(file.isDirectory()){
            File [] files = file.listFiles();
            if(files != null)
            for(File f : files) {
                if(f != null)
                    deepSearch(f, str + "-");
            }
        }
        else{
            if(file != null){
                System.out.println(str + file);
            }
        }
    }
}
