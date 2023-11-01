package Seminar04_task1;

public class Main {
    public static void main(String[] args) {
        try {
            LoginAndPasswordChecker.validate("qwe", "123", "123");
            LoginAndPasswordChecker.validate("qwe", "123", "567890");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

        /*
         * Отсюда и ниже - задание номер 5: В основном классе программы необходимо по-разному обработать исключения.
         */
        boolean flag = true;
        try {
            LoginAndPasswordChecker.validate("1234567890_1234567890_1234567890", "123", "123");
        } catch (WrongLoginException | WrongPasswordException e) {
            flag = false;
        } finally {
            System.out.println(flag);
        }
    }
}
