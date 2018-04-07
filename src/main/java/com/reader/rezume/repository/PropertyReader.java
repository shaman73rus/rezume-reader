package com.reader.rezume.repository;

import com.reader.rezume.entity.PersonalData;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Component
public class PropertyReader {

    private Properties personDataFile = new Properties();
    private PersonalData personalData;

    public Properties getPropertiesFromFile(String pathProperties) throws IOException {
        personDataFile.load(new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathProperties), "UTF-8")));
        return personDataFile;
    }

    public PersonalData setFillingData(String pathProperties) throws IOException {
       personDataFile = getPropertiesFromFile(pathProperties);
        personalData = new PersonalData(
                personDataFile.getProperty(PersonPropertyKeys.FIO),
                personDataFile.getProperty(PersonPropertyKeys.DOB),
                personDataFile.getProperty(PersonPropertyKeys.PHONE),
                personDataFile.getProperty(PersonPropertyKeys.EMAIL),
                personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                personDataFile.getProperty(PersonPropertyKeys.TARGET),
                personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES),
                personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS),
                personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                personDataFile.getProperty(PersonPropertyKeys.SKILLS),
                personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE));
        return personalData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }


}
