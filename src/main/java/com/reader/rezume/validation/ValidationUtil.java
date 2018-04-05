package com.reader.rezume.validation;

import java.io.*;

public class ValidationUtil {

    public static boolean isValidArguments(String[] filePath) throws FileNotFoundException {

        if (filePath.length < 2) {
            //log.info("No arguments are entered");
            throw new IllegalArgumentException("You provide less then count of parameters: " +  filePath.length);
        }

        if (!isValidFile(filePath[0]) & !isValidFile(filePath[1])){
            throw new IllegalArgumentException("One of the file is invalid! Please, specify valid files!");

        }
        return true;
    }

    private static boolean isValidFile(String path) throws FileNotFoundException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path to file not specified!");
        }

        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getName() + " is not exist!");
        }

        if (!file.canRead()){
            throw new IllegalArgumentException("Cannot read file! Path: " + file.getName());
        }

        return true;
    }
}
