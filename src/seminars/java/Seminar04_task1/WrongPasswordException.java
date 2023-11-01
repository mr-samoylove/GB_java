package Seminar04_task1;

public class WrongPasswordException extends Exception {
    WrongPasswordException() {
        super();
    }

    WrongPasswordException(String msg) {
        super(msg);
    }
}
