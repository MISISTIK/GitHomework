package ua.itea;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 */
public class App {

    private static PrintWriter pw = null;

    private static void logToFile(String s) {
        pw.println(s);
    }

    private static void createLogFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy");
        String ldate = dtf.format(LocalDate.now());

        try {
            if (!Files.exists(Paths.get("logs/log_" + ldate + ".txt"))) {
                Files.createDirectories(Paths.get("logs"));
                Files.createFile(Paths.get("logs/log_" + ldate + ".txt"));
            }
            pw = new PrintWriter(new FileWriter("logs/log_" + ldate + ".txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void closeLogFile() {
        if (pw != null) {
            pw.close();
        }
    }
    public static void main(String[] args)
    {
       createLogFile();

       logToFile("First log write");

       closeLogFile();
    }
}
