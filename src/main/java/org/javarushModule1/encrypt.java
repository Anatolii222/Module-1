package org.javarushModule1;

import java.nio.file.Path;

public class encrypt extends global implements MenuExecutor  {

    public void execute(String path) {
        int key = getKey();
        if (key < 0) {
            throw new NumberFormatException("Число не має бути мінусовим");
        }
        String textEN = fileService.read(path);
        cryptService.modifiedStringWithCapitalLetter(key);
        cryptService.modifiedSymbol(key);
        cryptService.modifiedStringWithSmallLetter(key);
        String encryptTextEN = cryptService.encrypt(textEN);
        Path pathForFIle = fileService.createFile(path, "encrypted");
        fileService.write(String.valueOf(pathForFIle), encryptTextEN);
        AllDone();
    }
}
