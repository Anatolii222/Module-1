package org.javarushModule1;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileService {
    Scanner scanner = new Scanner(System.in);
    public String read(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println("Будь ласка перевірте шлях до файлу");
        }
        return text.toString();
    }
    public void write(String fileName, String text)  {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println("Не удалось записать в файл. Будь ласка перевірте шлях до файлу.");
        }
    }
    public Path createFile(String fileName, String nameFunc) {
        try {
            String[] tmp = fileName.split("\\.");
            fileName = tmp[0];
            Path filePath = Path.of(fileName + "[" + nameFunc.toUpperCase() + "]" + ".txt");

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            } else {
                System.out.println("Файл вже існує, перезаписати?");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    Files.delete(filePath);
                    Files.createFile(filePath);
                } else {
                    return null;
                }
            }
            return filePath;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
