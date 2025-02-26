package com.filehandling;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.List;

public class FileHandler {
    
    private static final String FILE_PATH = "D:\\Codetech\\file.txt";

    // Method to write content to a file
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("Content written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content by replacing a word
    public static void modifyFile(String oldWord, String newWord) {
        try {
            Path path = Paths.get(FILE_PATH);
            List<String> lines = Files.readAllLines(path);
            List<String> modifiedLines = lines.stream()
                    .map(line -> line.replace(oldWord, newWord))
                    .collect(Collectors.toList());
            Files.write(path, modifiedLines);
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Sample content to write
        String content = "Hello, this is a sample text file.\nThis file is used for Java file handling operations.";
        
        // Perform file operations
        writeToFile(content);
        readFromFile();
        
        // Modify file by replacing a word
        modifyFile("Java", "Advanced Java");
        readFromFile();  // Read again to verify changes
    }
}

