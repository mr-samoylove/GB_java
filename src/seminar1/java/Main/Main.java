package Main;

import arithmetic.Calculator;
import arithmetic.Printer;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Printer printer = new Printer();
        printer.printToConsole(calc.sum(1, 2, 3, 4));
    }
}