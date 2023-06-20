package sem5;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BackUpper {
    Path OUTPUT_BACKUP_DIRECTORY = Path.of("./backup");

    public BackUpper() {
        try {
            Files.createDirectory(OUTPUT_BACKUP_DIRECTORY);
        } catch (FileAlreadyExistsException e) {
            System.out.println("BackUpper: пишу в существующую папку " + OUTPUT_BACKUP_DIRECTORY);
        } catch (IOException e) {
            System.out.println("BackUpper: Ошибка при работе с директорией" + OUTPUT_BACKUP_DIRECTORY);
            e.printStackTrace();
        }
    }


    /**
     * Сохраняет файлы в переданной папке в OUTPUT_BACKUP_DIRECTORY. Игнорирует поддиректории.
     *
     * @param path например, "." или "./your/path"
     */
    public void backUpFiles(Path path) {
        try (Stream<Path> filesStream = Files.list(path)) {
            for (Path file : filesStream.toList()) {
                if (Files.isRegularFile(file)) {
                    Files.copy(file, OUTPUT_BACKUP_DIRECTORY.resolve(file.getFileName()), REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при использовании пути: " + path);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
