package Seminar04_task1;

public class WrongLoginException extends Exception {
    WrongLoginException() {
        super();
    }

    WrongLoginException(String msg) {
        super(msg);
    }
}
