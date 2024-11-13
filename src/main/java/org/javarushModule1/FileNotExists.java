package org.javarushModule1;

public class FileNotExists extends RuntimeException {
    public FileNotExists(String message) {
        super(message);
    }
}
