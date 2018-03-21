package com.reader.rezume.repository.impl;

import com.reader.rezume.constants.PersonPropertyKeys;
import com.reader.rezume.entity.PersonalData;
import com.reader.rezume.repository.PersonRepository;

import java.io.*;
import java.util.Properties;

/**
 * Implementing the repository @see {@link PersonRepository}
 *
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class PersonRepositoryFromPropertyFile implements PersonRepository {

    /**
     * Properties from a file with an extension .properties
     */
    private Properties personDataFile;

    /**
     * Constructor that calls the method for populating properties
     * @param configFileInput property file path
     * @throws IOException
     */
    public PersonRepositoryFromPropertyFile(String configFileInput) throws IOException {
        this.personDataFile = getPropertiesFromFile(configFileInput);
    }

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

    /**
     * @see PersonRepository
     */
    @Override
    public PersonalData getPersonalDataOfProperties() {
        PersonalData personalData = new PersonalData();
        if(this.personDataFile != null) {
            personalData.setFIO(personDataFile.getProperty(PersonPropertyKeys.FIO));
            personalData.setDOB(personDataFile.getProperty(PersonPropertyKeys.DOB));
            personalData.setPhone(personDataFile.getProperty(PersonPropertyKeys.PHONE));
            personalData.setEmail(personDataFile.getProperty(PersonPropertyKeys.EMAIL));
            personalData.setSkype(personDataFile.getProperty(PersonPropertyKeys.SKYPE));
            personalData.setAvatarPath(personDataFile.getProperty(PersonPropertyKeys.AVATAR));
            personalData.setTarget(personDataFile.getProperty(PersonPropertyKeys.TARGET));
            personalData.setExperiences(personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES));
            personalData.setEducations(personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS));
            personalData.setAdditionalEducations(personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS));
            personalData.setSkills(personDataFile.getProperty(PersonPropertyKeys.SKILLS));
            personalData.setExamplesCode(personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE));
        }
        return personalData;
    }
}