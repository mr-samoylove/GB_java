package old.sem5;

import java.io.File;
import java.nio.file.Path;

public class Tree {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Запускает рекурсивный обход по папкам и рисует в консоль список директорий и папок.
     *
     * @param path путь к директории, с которой нужно начинать рисовать дерево
     */
    public static void print(Path path) {
        Tree.print(path.toFile(), "", true);
    }

    private static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isFile())
            System.out.println(ANSI_GREEN + file.getName() + ANSI_RESET);
        else
            System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int subFilesTotal = 0;
        for (File currentFile : files) {
            if (currentFile.isDirectory())
                subDirTotal++;
            else
                subFilesTotal++;
        }

        int subDirCounter = 0;
        int subFilesCounter = 0;
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                print(currentFile, indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            } else {
                print(currentFile, indent, subFilesCounter == subFilesTotal - 1);
                subFilesCounter++;
            }
        }


    }

}
