package org.javarushModule1;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner extends global {

    private  final String[] namesForMenu = {"Зашифрувати", "Розшифрувати","Вийти"};

    String[] args;
    public Runner(String[] args) {
        this.args = args;
        if (args.length > 1) {
            run();
        }
        else {
            CLI();
        }
    }
    public void run() {
        Commands command = Commands.valueOf(args[0]);
        if (Integer.parseInt(args[2]) < -1) {
            throw new NumberFormatException("Число не має бути мінусовим");
        }
        switch (command) {
            case ENCRYPT:
                String textEN = fileService.read(args[1]);
                cryptService.modifiedStringWithCapitalLetter(Integer.parseInt(args[2]));
                cryptService.modifiedSymbol(Integer.parseInt(args[2]));
                cryptService.modifiedStringWithSmallLetter(Integer.parseInt(args[2]));
                String encryptTextEN = cryptService.encrypt(textEN);
                Path path = fileService.createFile(args[1], "encrypted");
                fileService.write(String.valueOf(path), encryptTextEN);
            break;
            case DECRYPT:
            String text = fileService.read(args[1]);
            cryptService.modifiedStringWithCapitalLetter(Integer.parseInt(args[2]));
            cryptService.modifiedSymbol(Integer.parseInt(args[2]));
            cryptService.modifiedStringWithSmallLetter(Integer.parseInt(args[2]));
            String decryptedText = cryptService.decrypt(text);
            Path pathDEC = fileService.createFile(args[1], "decrypted");
            fileService.write(String.valueOf(pathDEC), decryptedText);
            break;
            default:
                throw new UnknownCommand(args[0] + " is not a valid command");
        }
        System.out.println("Все зроблено");
    }
    public void CLI() {
        while (true){
            System.out.println("Вітаю в программі \"Шифр Цезаря\"");
            int i = 1;
            for (String index : namesForMenu) {
                System.out.println(i + ". "+namesForMenu[i-1]);
                i++;
            }
            System.out.println("Будь ласка введить номер пункту");
            int key = scanner.nextInt();
            Commands command = Commands.EXIT;
            try {
               command = Commands.valueOf(String.valueOf(Commands.values()[key-1]));
            } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ArrayIndexOutOfBoundsException("Немає такого пункту");

            }
            System.out.println(command);
            switch (command){
                case ENCRYPT:
                    System.out.println("Введіть путь до файлу");
                    String path = scanner.next();
                    new encrypt().execute(path);
                    break;
                case DECRYPT:
                    System.out.println("Введіть путь до файлу");
                    String pathDEC = scanner.next();
                    new decrypt().execute(pathDEC);
                    break;
                case EXIT:
                    new exit().execute();
                    break;
                default:
                    throw new UnknownCommand(command.name() + " is not a valid command");
        }
        }
    }
}
