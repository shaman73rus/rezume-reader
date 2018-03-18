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
    public String getStringFromHtmlFile(String path) throws IOException {
        String nameOS = System.getProperty("os.name");
        StringBuilder stringBuilder = new StringBuilder();

        if (nameOS.contains("Windows")) {
            readFileFromWindowsSystem(path, stringBuilder);
        } else if (nameOS.contains("Linux")) {
            readFileFromLinuxSystem(path, stringBuilder);
        } else {
            readFileFromMacSystem(path, stringBuilder);
        }
        return stringBuilder.toString();
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param path
     * @param stringBuilder
     * @throws IOException
     */
    private void readFileFromLinuxSystem(String path, StringBuilder stringBuilder) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "UTF-8"));
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
    }

    private void readFileFromMacSystem(String path, StringBuilder stringBuilder) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "MacCyrillic"));
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param path
     * @param stringBuilder
     * @throws IOException
     */
    private void readFileFromWindowsSystem(String path, StringBuilder stringBuilder) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "Cp1251"));
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
    }
}
