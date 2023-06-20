package sample;

import Seminar01.LineDecorator;
import Seminar01.WriterToFile;

public class Main {
    public static void main(String[] args) {
        String data = "Hello, world!";
        data = LineDecorator.decorate(data);
        WriterToFile.write(data);
    }
}