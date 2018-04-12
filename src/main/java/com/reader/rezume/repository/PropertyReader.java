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
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.FIO.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.DOB.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.phone.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.email.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.skype.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.avatar.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.target.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.experiences.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.educations.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.additional_educations.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.skills.name()),
                personDataFile.getProperty(PersonPropertyKeys.PropertyKeys.examples_code.name()));
        return personalData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }


}
