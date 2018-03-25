package com.reader.rezume.repository.impl;

import com.reader.rezume.repository.PersonRepository;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class PersonRepositoryFromPropertyFile implements PersonRepository {

    private Properties personDataFile;

    public PersonRepositoryFromPropertyFile(String configFileInput, String coding) throws IOException {
        this.personDataFile = getPropertiesFromFile(configFileInput, coding);
    }

    public Properties getPropertiesFromFile(String propertyPath, String coding) throws IOException {
        Properties properties = new Properties();

        properties.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(propertyPath), coding)));
        return properties;
    }

    @Override
    public Map getPersonalDataOfProperties() {
        return this.personDataFile;
    }
}