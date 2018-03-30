package com.reader.rezume.repository.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyReader extends Thread {
    private String propertyPath;
    private String coding;
    private Properties properties;
    public Thread t;

    PropertyReader(String propertyPath, String coding) {
        this.propertyPath = propertyPath;
        this.coding = coding;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            this.properties = getPropertiesFromFile(propertyPath, coding);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getPropertiesFromFile(String propertyPath, String coding) throws IOException {
        Properties properties = new Properties();
        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), coding)));
        return properties;
    }

    Properties getPersonalDataOfProperties() {
        return this.properties;
    }
}
