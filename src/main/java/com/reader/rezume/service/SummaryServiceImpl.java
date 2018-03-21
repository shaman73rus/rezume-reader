package com.reader.rezume.service;

import com.reader.rezume.constants.PersonPropertyKeys;
import com.reader.rezume.entity.PersonalData;
import com.reader.rezume.repository.PersonRepository;
import com.reader.rezume.repository.impl.PersonRepositoryFromPropertyFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the interface @see {@link SummaryService}
 */
public class SummaryServiceImpl implements SummaryService {

    /**
     * Implementation of the method in the interface @see {@link SummaryService}
     * @param pathHtmlFile path to the html file
     * @param pathProperties path to the Property file
     * @throws IOException
     */
    @Override
    public void createHtmlFile(String pathHtmlFile, String pathProperties) throws IOException {
        PersonRepository personRepository = new PersonRepositoryFromPropertyFile(pathProperties);
        PersonalData personalData = personRepository.getPersonalDataOfProperties();
        Map<String, String> mapProperties = createMapProperties(personalData);

        try {
            writeToFile(pathHtmlFile, personalData, mapProperties);
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Method for creating map with properties
     * @param personalData
     * @return mapProperties
     */
    private Map<String, String> createMapProperties(PersonalData personalData) {
        Map<String,String> mapProperties = new HashMap<>();
        mapProperties.put(PersonPropertyKeys.FIO, personalData.getFIO());
        mapProperties.put(PersonPropertyKeys.DOB, personalData.getDOB());
        mapProperties.put(PersonPropertyKeys.PHONE, personalData.getPhone());
        mapProperties.put(PersonPropertyKeys.EMAIL, personalData.getEmail());
        mapProperties.put(PersonPropertyKeys.SKYPE, personalData.getSkype());
        mapProperties.put(PersonPropertyKeys.AVATAR, personalData.getAvatar());
        mapProperties.put(PersonPropertyKeys.TARGET, personalData.getTarget());
        mapProperties.put(PersonPropertyKeys.EXPERIENCES, personalData.getExperiences());
        mapProperties.put(PersonPropertyKeys.EDUCATIONS, personalData.getEducations());
        mapProperties.put(PersonPropertyKeys.ADDITIONAL_EDUCATIONS, personalData.getAdditionalEducations());
        mapProperties.put(PersonPropertyKeys.SKILLS, personalData.getSkills());
        mapProperties.put(PersonPropertyKeys.EXAMPLES_CODE, personalData.getExamplesCode());
        return mapProperties;
    }

    /**
     * Method for writing an html file
     * @param pathHtmlFile file path for writes
     * @param personalData
     * @param mapProperties properties
     * @throws IOException
     */
    private void writeToFile(String pathHtmlFile, PersonalData personalData, Map<String, String> mapProperties) throws IOException {

        if (pathHtmlFile.isEmpty() && personalData==null) {
            throw new IllegalArgumentException("Error saving file path!");
        }

        BufferedReader reader = TemplateService.getStringFromHtmlFile(pathHtmlFile);
        File file = new File(pathHtmlFile.replaceAll("index.html", "rezume_index.html"));
        Writer writer = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(setPropertyValuesInTemplate(line, mapProperties));
        }

        writer.close();
    }

    /**
     * Method inserts values ​​into a template using the properties found
     * @param line string from html file
     * @param mapProperties property
     * @return
     */
    private String setPropertyValuesInTemplate(String line, Map<String,String> mapProperties) {
        for (Map.Entry<String, String> entry : mapProperties.entrySet()) {
            if (line.contains(entry.getKey())) {
                line = line.replace('$' + entry.getKey(), entry.getValue());
            }
        }
        return line;
    }
}
