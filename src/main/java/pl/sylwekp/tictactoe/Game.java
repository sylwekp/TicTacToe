package pl.sylwekp.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Board board;
    private Sign current;
    private Scanner scanner;
    private int freeFields;

    private static int scoreO;
    private static int scoreX;

    public Game() {
        board = new Board();
        freeFields = board.ROWS * board.COLS;
        scanner = new Scanner(System.in);
    }

    public void prepareAndStart() {
        board.clearBoard();
        start();
    }

    public void start() {
        setStartingPlayer();
        while (isFreeField()) {
            board.printBoard();
            System.out.print("In move: ");
            printCurrentSign();

            boolean correctField = false;
            while (!correctField) {
                try {
                    System.out.println("Type position - ROW and COL: ");
                    int row = Integer.parseInt(scanner.next());
                    int col = Integer.parseInt(scanner.next());
                    board.move(current, row - 1, col - 1);
                    correctField = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Incorrect input!");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Position out of board!");
                } catch (FieldIsTakenException e) {
                    System.out.println("This field is taken!");
                }
            }

            if (--freeFields < 5) {
                if (board.checkIfWon()) {
                    System.out.print("Winner: ");
                    printCurrentSign();
                    board.printBoard();
                    addPoint();
                    printScores();
                    return;
                }
            }

            switchPlayer();
        }
        System.out.println("DRAW!");
        board.printBoard();
        printScores();
    }

    private void setStartingPlayer() {
        String startingSign;
        do {
            System.out.print("Who starts? x/o: ");
            startingSign = scanner.next().toLowerCase();
        } while (!startingSign.equals("x") && !startingSign.equals("o"));

        if (startingSign.equals("x")) {
            current = Sign.PLAYER_X;
        } else {
            current = Sign.PLAYER_O;
        }
    }

    private void switchPlayer() {
        if (current == Sign.PLAYER_O) {
            current = Sign.PLAYER_X;
        } else {
            current = Sign.PLAYER_O;
        }
    }

    private void printCurrentSign() {
        System.out.println(current.getSign());
    }

    private boolean isFreeField() {
        return freeFields > 0 ? true : false;
    }

    private void addPoint() {
        if (current == Sign.PLAYER_O) {
            scoreO++;
        } else {
            scoreX++;
        }
    }

    private void printScores() {
        System.out.println("Player O: " + scoreO);
        System.out.println("Player X: " + scoreX);
    }
}
