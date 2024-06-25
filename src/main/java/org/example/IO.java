package org.example;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Getter
public class IO implements FilleInterface{
    String nameLastFile;
    @Override
    public void createLog() {
        File log = new File("log");
        if (!log.exists()) {
            log.mkdir();
        }
    }

    public String genarateFileName(){
        return "log/log_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy")) + ".txt";
    }
    @Override
    public void writeFile(String str, String name) {
        cleanLogDirectory();
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanLogDirectory() {
        File logDir = new File("log");
        File[] files = logDir.listFiles();
        if (files != null && files.length > 1) {
            Arrays.stream(files)
                    .sorted((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()))
                    .skip(1)
                    .forEach(File::delete);
        }
    }

    @Override
    public String readFile(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(name);
            int ch ;
            while ((ch = fileReader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
