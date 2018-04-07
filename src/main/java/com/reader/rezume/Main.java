package com.reader.rezume;

import com.reader.rezume.repository.PropertyReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        PropertyReader data = context.getBean(PropertyReader.class);
        data.setFillingData(args[0]);
    }
}
