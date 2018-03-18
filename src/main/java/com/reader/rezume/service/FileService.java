package com.reader.rezume.service;

import java.io.*;

/** Class to write a file
 * @author Khvatkov Nikita
 * @since 1.0.0
 * @version 1.0.0
 */
public class FileService {

    /**
     * Method for writing to a file that takes 2 parameters
     * @param fileContent ready template
     * @param filePath file path
     * @throws IOException Invalid file path
     */
    public void writeToFile(String fileContent, String filePath) throws IOException {
        if (filePath.isEmpty()) {
            throw new IllegalArgumentException("Error saving file path!");
        }
        //write to file with OutputStreamWriter
        File file = new File(filePath.replaceAll("index.html", "rezume_index.html"));
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();
    }
}
