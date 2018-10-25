package ua.itea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args)
    {
        if (Files.exists(Paths.get("logs"))) {
            try {
                Files.createDirectory(Paths.get("logs"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
