package Main;

import sem5.*;

import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        BackUpper backUpper = new BackUpper();
        backUpper.backUpFiles(Path.of("."));
        backUpper.backUpFiles(Path.of("./src/seminars/java/sem4"));

        Tree.print(Path.of("./src"));
    }
}