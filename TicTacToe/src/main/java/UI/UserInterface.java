package UI;

import domain.TicTacToe;

import java.util.Scanner;

public class UserInterface {

    TicTacToe ticTacToe = new TicTacToe();
    Scanner scanner = new Scanner(System.in);
    private final char player1 = 'x';
    private final char player2 = 'o';
    private boolean switchPlayer = true;

    public void start() {
        System.out.println("Welcome to a game of Tic Tac Toe");
        while (ticTacToe.getValidPlaces() > 0) {
            playerUI(player1);
            if (switchPlayer == true) {
                playerUI(player2);
            }
        }
    }

    private void playerUI(char player) {
        ticTacToe.printBoard();
        System.out.println("Player " + player + "'s turn");
        System.out.println("Choose a row");
        int row = scanner.nextInt();
        System.out.println("Choose a column");
        int column = scanner.nextInt();
        if (ticTacToe.isValidPlace(row, column)) {
            ticTacToe.putValue(player, row, column);
            if (ticTacToe.isWinner(player)) {
                System.out.println("Player " + player + " has won. Congratulations!!!");
                playAgainOrNot();
                switchPlayer = false;
                return;
            }
            ticTacToe.reduceValidPlaces();
            if (ticTacToe.isGameOver()) {
                switchPlayer = false;
                System.out.println("Game Over. Do you wish to play again?");
                playAgainOrNot();
            }
        } else {
            System.out.println("Choose a valid place");
            playerUI(player);
        }

    }

    private void playAgainOrNot() {
        System.out.println("Do you wish to play again? YES[y] or NO[n]");
        String s = scanner.next();
        if (s.toLowerCase().equals("y")) {
            switchPlayer = true;
            ticTacToe.refreshBoard();
            start();
        }
    }

}
