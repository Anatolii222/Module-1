package org.javarushModule1;

import java.nio.file.Path;

public class decrypt extends global implements MenuExecutor{
    public void execute(String path) {
        int key = getKey();
        if (key < 0) {
            throw new NumberFormatException("Число не має бути мінусовим");
        }
        String text = fileService.read(path);
        cryptService.modifiedStringWithCapitalLetter(key);
        cryptService.modifiedSymbol(key);
        cryptService.modifiedStringWithSmallLetter(key);
        String decryptedText = cryptService.decrypt(text);
        Path pathDEC = fileService.createFile(path, "decrypted");
        fileService.write(String.valueOf(pathDEC), decryptedText);
        AllDone();
    }
}
