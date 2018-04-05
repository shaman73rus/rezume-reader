package com.reader.rezume.repository.impl;

import com.reader.rezume.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.util.Properties;

@Component
public class PersonRepositoryFromPropertyFile implements PersonRepository {

    private Properties personDataFile;
    private PropertyReader propertyReader;

    @Autowired
    public PersonRepositoryFromPropertyFile(@Qualifier("propertyReader") PropertyReader propertyReader) throws IOException {
        this.propertyReader = propertyReader;
    }

    @Override
    public void readToWriteProperty(String configFileInput, String coding) throws IOException {
        personDataFile = propertyReader.getPropertiesFromFile(configFileInput, coding);
    }

    @Override
    public Map getPersonalDataOfProperties() {
        return this.personDataFile;
    }
}