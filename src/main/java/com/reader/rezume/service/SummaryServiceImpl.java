package com.reader.rezume.service;

import com.reader.rezume.repository.PersonRepository;
import com.reader.rezume.repository.impl.PersonRepositoryFromPropertyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class SummaryServiceImpl implements SummaryService {

    private PersonRepository personRepository;

    @Autowired
    public SummaryServiceImpl(@Qualifier("personRepositoryFromPropertyFile") PersonRepositoryFromPropertyFile personRepositoryFromPropertyFile) {
        this.personRepository = personRepositoryFromPropertyFile;
    }

    @Override
    public void createHtmlFile(String pathHtmlFile, String pathProperties, String coding) throws IOException {
        personRepository.readToWriteProperty(pathProperties, coding);

        Map<String, String> personalData = personRepository.getPersonalDataOfProperties();

        try {
            writeToFile(pathHtmlFile, personalData, coding);
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void writeToFile(String pathHtmlFile,  Map<String, String> personalData, String coding) throws IOException {

        if (pathHtmlFile.isEmpty() && personalData==null) {
            throw new IllegalArgumentException("Error saving file path!");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathHtmlFile), coding));
        File file = new File(pathHtmlFile.replaceAll("index.html", "rezume_index.html"));
        Writer writer = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()));

        Map<String, List<String>> stringListHashMap = new HashMap<>();
        for (Map.Entry<String, String> entry : personalData.entrySet()) {
            List<String> split = new ArrayList<>(Arrays.asList(entry.getValue().split(",")));
            stringListHashMap.put(entry.getKey(), split);
        }

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(setPropertyValuesInTemplate(line, stringListHashMap));
        }

        writer.close();
    }

    private String setPropertyValuesInTemplate(String line, Map<String,List<String>> mapProperties) {

        for (Map.Entry<String, List<String>> entry : mapProperties.entrySet()) {
            if (line.contains(entry.getKey())) {
                String string = entry.getValue().get(0);
                if (line.contains('$' + entry.getKey())) {
                    line = line.replace('$' + entry.getKey(), string);
                    if (entry.getValue().size() != 1) {
                        entry.getValue().remove(0);
                    }
                }
            }
        }
        return line;
    }
}