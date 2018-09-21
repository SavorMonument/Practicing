package Algorithms;

import java.io.File;

public class ListFiles1343 {

    public static void printFiles(File f, int padding){
        assert (null != f);

        System.out.println(f.getName());
        File[] files = f.listFiles();

        for(File file: files){

            for(int i = 0; i < padding * 2;i++){ System.out.print(" "); }
            if (file.isDirectory())
                printFiles(file, padding + 1);
            else
                System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {

        printFiles(new File("D:\\desktop\\racing simulation 2d"), 0);
    }


}
