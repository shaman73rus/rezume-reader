package com.reader.rezume.service;

import java.io.IOException;

/**
 * Service for creating an HTML file for a resume
 *
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public interface SummaryService {

    /**
     * Method for creating an html-file
     * @param Path - path to save the html file
     */
    void createHtmlFile(String Path, String filePaths) throws IOException;
}