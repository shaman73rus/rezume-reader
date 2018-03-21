package com.reader.rezume.validation;

import java.io.*;


/**
 * Class to verify the validation of received files
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class ValidationUtil {
    //private static final Logger log = Logger.getLogger(ValidationUtil.class);
    /**
     * Method for verifying the validity of files
     * @param filePath array of entered values
     * @throws FileNotFoundException Invalid file path and Arguments are not specified!
     */
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

    /**
     * Method for checking the existence and reading of a file
     * @param path file path
     * @return value type boolean
     * @throws FileNotFoundException Invalid file path
     */
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
