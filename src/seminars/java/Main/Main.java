package Main;

import sem2.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3, 4, 10);
        game.start();
    }
}