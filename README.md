# BattleShip
# Battleship Game

This is a simple implementation of the Battleship game in Java. The game allows the player to guess the locations of ships on a game board until all ships are detected.

## How to Play

1. The game board is represented using a 2D array, where each cell represents a position on the board.
2. Ships are represented by the character 's' and water is represented by the character '-'.
3. The player needs to guess the coordinates of the ships by entering the row and column numbers.
4. The game board is displayed after each guess, showing the positions of ships, hits ('X'), and misses ('O').
5. The game continues until all ships are detected, and the player wins.

## Code Overview

The code is organized into several methods to handle different functionalities:

- `main`: The entry point of the program. It initializes the game board, prints the initial game board, and starts the game loop.
- `updateGameBoard`: Updates the game board with the result of the player's guess.
- `evaluateGuessAndGetTheTarget`: Evaluates the player's guess and returns the corresponding target character ('X' for hit, 'O' for miss, or 'Already Hit!' if the position was already guessed).
- `getUserCoordinates`: Prompts the user to enter the row and column coordinates and returns them as an array.
- `printGameBoard`: Prints the current state of the game board, showing the positions of ships, hits, and misses.
- `createGameBoard`: Creates the initial game board filled with water and places the ships randomly.
- `placeShips`: Places the ships on the game board by randomly selecting positions.
- `generateShipCoordinates`: Generates random coordinates for placing a ship.

## Customization

You can customize the game by modifying the following variables in the `main` method:

- `gameBoardLength`: Determines the size of the game board.
- `water`: Represents the character used to display empty positions.
- `ship`: Represents the character used to display ships.
- `hit`: Represents the character used to display a hit.
- `miss`: Represents the character used to display a miss.
- `shipNumber`: Determines the number of ships to be placed on the game board.

You can adjust these variables to change the game's difficulty or appearance.

Have fun playing Battleship!
# BattleShip
