package com.reader.rezume.repository.impl;

import com.reader.rezume.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

@Component
public class PropertyReader {

    public Properties getPropertiesFromFile(String propertyPath, String coding) throws IOException {
        Properties properties = new Properties();
        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), coding)));
        return properties;
    }
}
