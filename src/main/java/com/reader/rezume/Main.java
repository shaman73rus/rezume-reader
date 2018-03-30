package com.reader.rezume;

import com.reader.rezume.service.SummaryService;
import com.reader.rezume.service.SummaryServiceImpl;
import com.reader.rezume.validation.ValidationUtil;

import java.io.IOException;

/**
 * Class from which all Java applications begin executing
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class Main {

    /**
     * This is the line from which the program begins
     * @param args array of entered values
     */
    public static void main(String[] args) throws IOException {
        if (ValidationUtil.isValidArguments(args)) {
            SummaryService summaryService = new SummaryServiceImpl();
            summaryService.createHtmlFile(args[0], args[1], args[2], args[3]);
        }
    }
}
