package com.reader.rezume.repository;

import java.io.IOException;
import java.util.Map;

public interface PersonRepository {
    void readToWriteProperty(String configFileInput, String coding) throws IOException;
    Map getPersonalDataOfProperties();
}