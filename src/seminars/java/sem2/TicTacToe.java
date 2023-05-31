package sem2;

import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();

    private final int lineLengthToWin; // сколько нужно поставить фишек в ряд для победы
    private final char[][] field; // Двумерный массив хранит текущее состояние игрового поля
    private int currentTurn = 0;

    private final int rows; // Размерность игрового поля
    private final int columns; // Размерность игрового поля

    // заготовки для отрисовки карты
    private final String header;
    private final String bodyDelimiter;
    private final String bottom;

    /**
     * @param lineLengthToWin сколько нужно поставить фишек в ряд для победы?
     * @param rows ширина поля
     * @param columns высота поля
     */
    public TicTacToe(int lineLengthToWin, int rows, int columns) {
        this.lineLengthToWin = lineLengthToWin;
        this.rows = rows;
        this.columns = columns;
        this.field = new char[rows][columns];

        this.header = '\u250c' + String.join("", Collections.nCopies(this.columns - 1, "---" + '\u252c')) + "---" + '\u2510';
        this.bodyDelimiter = '\u251c' + String.join("", Collections.nCopies(this.columns - 1, "---" + '\u253c')) + "---" + '\u2524';
        this.bottom = '\u2514' + String.join("", Collections.nCopies(this.columns - 1, "---" + '\u2534')) + "---" + '\u2518';
    }


    public void start() {
        while (true) {
            setFieldsAsEmpty();
            printField();
            while (currentTurn != rows * columns) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.println("Игра Завершена.\nЖелаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private void setFieldsAsEmpty() {
        // Пройдем по всем элементам массива
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
        this.currentTurn = 0;
    }

    /**
     * Отрисовка игрового поля
     */
    private void printField() {
        System.out.println(this.header);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print("| " + field[i][j] + ' ');

            System.out.println("|");
            if (i != rows - 1)  // если это не последняя строка
                System.out.println(this.bodyDelimiter);
            else System.out.println(this.bottom); // если последняя строка
        }
    }

    /**
     * Обработка хода игрока (человек)
     */
    private void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты хода X (ряд) и Y (колонка) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
        this.currentTurn++;
    }

    /**
     * Проверка, ячейка является пустой
     *
     * @param x
     * @param y
     * @return
     */
    boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    boolean isCellValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    /**
     * Ход компьютера
     */
    private void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(rows);
            y = random.nextInt(columns);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
        this.currentTurn++;
    }

    /**
     * Проверка победы
     *
     * @param c
     * @return
     */
    boolean checkWin(char c) {

        // нет смысла проверять победу, если фишек поставлено меньше, чем необходимо для победы
        if (currentTurn < lineLengthToWin * 2) // здесь 2 - это количество игроков, т.к. currentTurn считает все ходы
            return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i][j] != c)
                    continue;

                // если справа достаточно игрового поля, чтобы была возможность победить
                if (j + lineLengthToWin <= columns) {
                    if (checkLine(c, i, j, "horizontally"))
                        return true;
                }

                // если снизу достаточно игрового поля, чтобы была возможность победить
                if (i + lineLengthToWin <= rows) {
                    if (checkLine(c, i, j, "vertically"))
                        return true;
                }

                // если по диагонали снизу справа достаточно игрового поля, чтобы была возможность победить
                if (j + lineLengthToWin <= columns && i + lineLengthToWin <= rows) {
                    if (checkLine(c, i, j, "diagonally to right"))
                        return true;
                }

                // если по диагонали снизу слева достаточно игрового поля, чтобы была возможность победить
                if (j - lineLengthToWin >= 0 && i + lineLengthToWin <= rows) {
                    if (checkLine(c, i, j, "diagonally to left"))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(char c, int i, int j, String mode) {
        switch (mode) {
            case "horizontally":
                for (int k = 0; k < lineLengthToWin; k++) {
                    if (field[i][j++] != c)
                        return false;
                }
                break;
            case "vertically":
                for (int k = 0; k < lineLengthToWin; k++) {
                    if (field[i++][j] != c)
                        return false;
                }
                break;
            case "diagonally to right":
                for (int k = 0; k < lineLengthToWin; k++) {
                    if (field[i++][j++] != c)
                        return false;
                }
                break;
            case "diagonally to left":
                for (int k = 0; k < lineLengthToWin; k++) {
                    if (field[i++][j--] != c)
                        return false;
                }
                break;
        }

        return true;
    }


    /**
     * Метод проверки состояния игры
     *
     * @param c
     * @param str
     * @return
     */
    boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        // проверка на ничью
        if (currentTurn == rows * columns) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

}

