import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 7;
        char water = '-';
        char ship = 's';
        char hit = 'X';
        char miss = 'O';
        int shipNumber = 3;
        char[][] gameBoard = createGameBoard(gameBoardLength, water, ship, shipNumber);
        printGameBoard(gameBoard, water, ship);
        int undetectedShipNumber = shipNumber;
        while (undetectedShipNumber > 0) {
            int[] guessCoordinates = getUserCoordinates(gameBoardLength);
            char locationViewUpdate = evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, ship, water, hit, miss);
            if (locationViewUpdate == hit) {
                undetectedShipNumber--;
            }
            gameBoard = updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
            printGameBoard(gameBoard, water, ship);
        }
        System.out.print("You Won!");
    }

    private static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    private static char evaluateGuessAndGetTheTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
        String message;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];
        if (target == ship) {
            message = "Hit!";
            target = hit;
        } else if (target == water) {
            message = "Miss!";
            target = miss;
        } else {
            message = "Already Hit!";
        }
        System.out.println(message);
        return target;
    }

    private static int[] getUserCoordinates(int gameBoardLength) {
        int row;
        int col;
        do {
            System.out.print("Row: ");
            char inputRow = new Scanner(System.in).next().toUpperCase().charAt(0);
            row = inputRow - 'A';
        } while (row < 0 || row >= gameBoardLength);
        do {
            System.out.print("Column (0-" + (gameBoardLength - 1) + "): ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col >= gameBoardLength);
        return new int[]{row, col};
    }

    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        int gameBoardLength = gameBoard.length;
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < gameBoardLength; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < gameBoardLength; col++) {
                char position = gameBoard[row][col];
                if (position == ship) {
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    private static char[][] createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }
        return placeShips(gameBoard, shipNumber, water, ship);
    }

    private static char[][] placeShips(char[][] gameBoard, int shipNumber, char water, char ship) {
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber) {
            int[] location = generateShipCoordinates(gameBoardLength);
            int row = location[0];
            int col = location[1];
            char possiblePlacement = gameBoard[row][col];
            if (possiblePlacement == water) {
                gameBoard[row][col] = ship;
                placedShips++;
            }
        }
        return gameBoard;
    }
    private static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}