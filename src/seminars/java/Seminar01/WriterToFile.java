package Seminar01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriterToFile {
    public static void write(String string) {
        Path path = Paths.get(".", "seminar01_output.txt");

        try {
            if (!Files.exists(path))
                Files.createFile(path);
            Files.writeString(path, string, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error wile writing to file:");
            System.out.println(e.getMessage());
        }
    }
}
