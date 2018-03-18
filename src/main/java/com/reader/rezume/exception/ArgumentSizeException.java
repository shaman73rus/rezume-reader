package com.reader.rezume.exception;

/**
 * Class to check the size of the argument
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class ArgumentSizeException extends RuntimeException {

    /**
     * Method displays an error message in the console
     * @param exception
     */
    public ArgumentSizeException(String exception) {
        System.out.println(exception);
    }
}
