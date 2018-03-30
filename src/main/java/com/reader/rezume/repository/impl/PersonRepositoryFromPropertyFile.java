package com.reader.rezume.repository.impl;

import com.reader.rezume.repository.PersonRepository;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class PersonRepositoryFromPropertyFile implements PersonRepository {

    private Properties personDataFile;

    public PersonRepositoryFromPropertyFile(String configFileInput, String filePath2, String coding) throws IOException {
        PropertyReader readerOnePropertyFile = new PropertyReader(configFileInput, coding);
        PropertyReader readerTwoPropertyFile = new PropertyReader(filePath2, coding);

        try {
            readerOnePropertyFile.t.join();
            readerTwoPropertyFile.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.personDataFile = readerOnePropertyFile.getPersonalDataOfProperties();
        this.personDataFile.putAll(readerTwoPropertyFile.getPersonalDataOfProperties());
    }

    @Override
    public Map getPersonalDataOfProperties() {
        return this.personDataFile;
    }
}