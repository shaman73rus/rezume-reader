package com.reader.rezume.service;

import java.io.*;

public class TemplateService {

    public static BufferedReader getStringFromHtmlFile(String path, String coding) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), coding));
        return reader;
    }
}
