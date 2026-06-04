package com.java.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WithTryWithResources {
    public static void main(String[] args) {

        // Tell Java to navigate into src, then your packages to find the file
        String file_path = "src/com/java/exceptionHandling/sample.txt";
        try(BufferedReader reader=new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
