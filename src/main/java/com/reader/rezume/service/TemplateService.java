package com.reader.rezume.service;

import java.io.*;

/**
 * Class to get an HTML template from a file in StringBuilder
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class TemplateService {

    /**
     * Method retrieves the HTML template from a file
     * @param path path to the HTML file
     * @return object of type StringBuilder
     * @throws IOException Invalid file path
     */
    public static BufferedReader getStringFromHtmlFile(String path) throws IOException {
        String nameOS = System.getProperty("os.name");

        BufferedReader reader;
        if (nameOS.contains("Windows")) {
           reader = readFileFromWindowsSystem(path);
        } else if (nameOS.contains("Linux")) {
            reader = readFileFromLinuxSystem(path);
        } else {
            reader = readFileFromMacSystem(path);
        }
        return reader;
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param path
     * @throws IOException
     */
    private static BufferedReader readFileFromLinuxSystem(String path) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "UTF-8"));
        return reader;
    }

    private static BufferedReader readFileFromMacSystem(String path) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "MacCyrillic"));
        return reader;
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param path
     * @throws IOException
     */
    private static BufferedReader readFileFromWindowsSystem(String path) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "Cp1251"));
        return reader;
    }
}
