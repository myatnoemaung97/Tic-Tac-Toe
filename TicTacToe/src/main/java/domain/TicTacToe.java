package domain;

public class TicTacToe {
    private final char[][] board;

    private int validPlaces = 9;

    public TicTacToe() {
        this.board = new char[3][3];
        initBoard();
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println();
            System.out.println("----------");
        }
    }

    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '#';
            }
        }
    }

    public void refreshBoard() {
        initBoard();
        validPlaces = 9;
    }

    public boolean isValidPlace(int row, int column) {
        return board[row][column] == '#';
    }

    public void putValue(char player, int row, int column) {
        board[row][column] = player;
    }

    public void reduceValidPlaces() {
        this.validPlaces--;
    }

    public int getValidPlaces() {
        return validPlaces;
    }

    public boolean isGameOver() {
        return validPlaces == 0;
    }

    public boolean isWinner(char player) {
        if (horizontally(player) || vertically(player) || diagonally(player)) {
            return true;
        }
        return false;
    }

    private boolean horizontally(char player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            return true;
        }
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            return true;
        }
        return false;
    }

    private boolean vertically(char player) {
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            return true;
        }
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            return true;
        }
        return false;
    }

    private boolean diagonally(char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }


}
