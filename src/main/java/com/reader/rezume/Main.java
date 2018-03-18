package com.reader.rezume;

import com.reader.rezume.service.FileService;
import com.reader.rezume.service.PropertyService;
import com.reader.rezume.service.ReplacementService;
import com.reader.rezume.service.TemplateService;
import com.reader.rezume.validation.ValidationUtil;

import java.io.IOException;
import java.util.Properties;

/**
 * Class from which all Java applications begin executing
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.011
 */
public class Main {

    /**
     * This is the line from which the program begins
     * @param args array of entered values
     */
    public static void main(String[] args) throws IOException {
        TemplateService templateService = new TemplateService();
        PropertyService propertyService = new PropertyService();
        FileService fileService = new FileService();
        ReplacementService replacementService = new ReplacementService();

        if (ValidationUtil.isValidArguments(args)) {
            String stringFromHtmlFile = templateService.getStringFromHtmlFile(args[0]);
            Properties properties = propertyService.getPropertiesFromFile(args[1]);
            fileService.writeToFile(replacementService.setPropertyValuesInTemplate(stringFromHtmlFile, properties), args[0]);
        }
    }
}
