package org.javarushModule1;

public class UnknownCommand extends RuntimeException {
    public UnknownCommand(String message) {
        super(message);
    }
}
