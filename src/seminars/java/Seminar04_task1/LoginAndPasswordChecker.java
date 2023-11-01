package Seminar04_task1;

public class LoginAndPasswordChecker {
    private static final int MAX_LOGIN_LENGTH = 20;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public static boolean validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= MAX_LOGIN_LENGTH)
            throw new WrongLoginException("login.length() >= MAX_LOGIN_LENGTH");

        if (password.length() >= MAX_PASSWORD_LENGTH)
            throw new WrongPasswordException("password.length() >= MAX_PASSWORD_LENGTH");

        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("password != confirmPassword");

        return true;
    }
}
