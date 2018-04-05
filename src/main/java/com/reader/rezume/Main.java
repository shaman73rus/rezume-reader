package com.reader.rezume;

import com.reader.rezume.repository.impl.PersonRepositoryFromPropertyFile;
import com.reader.rezume.service.SummaryService;
import com.reader.rezume.service.SummaryServiceImpl;
import com.reader.rezume.validation.ValidationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        if (ValidationUtil.isValidArguments(args)) {
            ConfigurableApplicationContext context = SpringApplication.run(Main.class);
            SummaryService summaryService = context.getBean(SummaryServiceImpl.class);
            summaryService.createHtmlFile(args[0], args[1], args[2]);
        }
    }
}
