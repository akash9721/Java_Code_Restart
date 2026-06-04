package com.java.exceptionHandling;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WithoutTryWithResources {
    public static void main(String[] args) {
        String filePath = "sample.txt";
        // 1. Declare the reference outside so it is visible to the finally block
        BufferedReader reader = null;

        try {
            // 2. Initialize the resource
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
            // 3. Manually handle the cleanup phase
            if (reader != null) {
                try {
                    // 4. Explicitly close the file stream
                    reader.close();
                } catch (IOException ex) {
                    System.err.println("Error closing reader: " + ex.getMessage());
                }
            }
        }
    }
}
