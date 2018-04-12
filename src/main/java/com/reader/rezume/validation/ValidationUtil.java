package com.reader.rezume.validation;

import java.io.*;

public class ValidationUtil {

    public static boolean isValidFile(String path) throws FileNotFoundException {
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
