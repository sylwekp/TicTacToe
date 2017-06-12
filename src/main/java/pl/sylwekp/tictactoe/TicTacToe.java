package pl.sylwekp.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Start game? Y/N");
        do {
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("y")) {
                Game game = new Game();
                game.prepareAndStart();
            }

            if (input.toLowerCase().equals("n")) {
                scanner.close();
                System.exit(0);
            }

            System.out.printf("%nPlay again? Y/N%n");
        } while (true);
    }
}
