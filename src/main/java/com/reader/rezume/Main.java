package com.reader.rezume;

import com.reader.rezume.repository.PropertyReader;
import com.reader.rezume.validation.ValidationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        PropertyReader data = context.getBean(PropertyReader.class);
        if (ValidationUtil.isValidFile(args[0])) {
            data.setFillingData(args[0]);
        }
    }
}
