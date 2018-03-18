package com.reader.rezume.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Class to get properties from a file to an object
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class PropertyService {

    /**
     * Method retrieves properties from a file
     * @param propertyPath file path with properties
     * @return object of type Property
     * @throws IOException Invalid file path
     */
    public Properties getPropertiesFromFile(String propertyPath) throws IOException {
        String nameOS = System.getProperty("os.name");
        Properties properties = new Properties();

        if (nameOS.contains("Windows")) {
            readFileFromWindowsOS(propertyPath, properties);
        } else if (nameOS.contains("Linux")) {
            readFileFromLinuxOS(propertyPath, properties);
        } else {
            readFileFromMacOS(propertyPath, properties);
        }
        return properties;
    }

    private void readFileFromMacOS(String propertyPath, Properties properties) throws IOException {
        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), "MacCyrillic")));
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param propertyPath
     * @param properties
     * @throws IOException
     */
    private void readFileFromWindowsOS(String propertyPath, Properties properties) throws IOException {
        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), "Cp1251")));
    }

    /**
     * Method receives data from a file in a particular encoding
     * @param propertyPath
     * @param properties
     * @throws IOException
     */
    private void readFileFromLinuxOS(String propertyPath, Properties properties) throws IOException {
        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), "UTF-8")));
    }
}
