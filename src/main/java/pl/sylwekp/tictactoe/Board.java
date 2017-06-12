package pl.sylwekp.tictactoe;

public class Board {

    public final int ROWS = 3;
    public final int COLS = 3;
    private Cell[][] cells;

    public Board() {
        cells = new Cell[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void clearBoard() {
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j < COLS; j++) {
                cells[i][j].clear();
            }
        }
    }

    public void printBoard() {
        Sign current;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                current = cells[i][j].getSign();
                if (current == Sign.EMPTY) {
                    System.out.print(current.getSign());
                } else if (current == Sign.PLAYER_O) {
                    System.out.print(current.getSign());
                } else if (current == Sign.PLAYER_X) {
                    System.out.print(current.getSign());
                }
            }
            System.out.println();
        }
    }

    public void move(Sign given, int row, int col) {
        Cell currentCell = cells[row][col];
        if (currentCell.getSign() == Sign.EMPTY) {
            currentCell.setSign(given);
        } else {
            throw new FieldIsTakenException();
        }
    }

    public boolean checkIfWon() {
        return (checkIfWonHorizontally() || checkIfWonVertically() || checkIfWonDiagonally());
    }

    private boolean checkIfWonHorizontally() {
        for (int i = 0; i < ROWS; i++) {
            if (checkRow(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row) {
        Sign temp;
        if ((temp = cells[row][0].getSign()) == Sign.EMPTY) {
            return false;
        }

        for (int i = 1; i < COLS; i++) {
            if (cells[row][i].getSign() != temp) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfWonVertically() {
        for (int i = 0; i < COLS; i++) {
            if (checkColumn(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int col) {
        Sign temp;
        if ((temp = cells[0][col].getSign()) == Sign.EMPTY) {
            return false;
        }

        for (int i = 1; i < COLS; i++) {
            if (cells[i][col].getSign() != temp) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfWonDiagonally() {
        return (checkFirstDiagonal() || checkSecondDiagonal());
    }

    private boolean checkFirstDiagonal() {
        Sign temp;
        if ((temp = cells[0][0].getSign()) == Sign.EMPTY) {
            return false;
        }

        for (int i = 1; i < COLS; i++) {
            if (cells[i][i].getSign() != temp) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal() {
        Sign temp;
        if ((temp = cells[0][2].getSign()) == Sign.EMPTY) {
            return false;
        }

        for (int i = 1; i < ROWS; i++) {
            if (cells[i][COLS - i - 1].getSign() != temp) {
                return false;
            }
        }
        return true;
    }
}
