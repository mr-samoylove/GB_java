package Seminar01;

public class Main {
    public static void main(String[] args) {
        String data = "Hello, world!";
        data = LineDecorator.decorate(data);
        WriterToFile.write(data);
    }
}