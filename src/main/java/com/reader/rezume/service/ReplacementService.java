package com.reader.rezume.service;

import java.util.Properties;

/**
 * Class for inserting values ​​in templates by found properties
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class ReplacementService {

    /**
     * Method inserts values ​​into a template using the properties found
     * @param templateHtml HTML template
     * @param properties
     * @return ready template of type String
     */
    public String setPropertyValuesInTemplate(String templateHtml, Properties properties) {
        for (String propertyName : properties.stringPropertyNames()) {
           String propertyValue = properties.getProperty(propertyName);
            if (propertyValue != null) {
                templateHtml = templateHtml.replace('$' + propertyName, propertyValue);
            } else {
                templateHtml = templateHtml.replace('$' + propertyName, "");
            }
        }
        return templateHtml;
    }
}
