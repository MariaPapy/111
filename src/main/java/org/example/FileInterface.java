package org.example;

public interface FileInterface {
    void createLog();
    void writeFile(String name, String str);
    void cleanLogDirectory();
    String readFile(String name);
}
