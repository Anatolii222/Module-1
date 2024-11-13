package org.javarushModule1;

import java.util.Scanner;

public abstract class global {
    protected Scanner scanner = new Scanner(System.in);
    protected FileService fileService = new FileService();
    protected cryptService cryptService = new cryptService();
    protected int getKey() {
        System.out.println("Введіть ключ(зсув)");
        return scanner.nextInt();
    }
    protected void AllDone() {
        System.out.println("Все зроблено");
    }
}
