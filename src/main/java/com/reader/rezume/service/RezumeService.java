package com.reader.rezume.service;

import com.reader.rezume.entity.PersonalData;
import com.reader.rezume.repository.PropertyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RezumeService {
    @Autowired
    private PropertyReader propertyReader;

    public PersonalData getProperties() throws IOException {
        return propertyReader.getPersonalData();
    }
}
