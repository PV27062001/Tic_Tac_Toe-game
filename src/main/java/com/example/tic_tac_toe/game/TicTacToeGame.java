package com.example.tic_tac_toe.game;

import java.util.Scanner;

public class TicTacToeGame {
    public static final char player_X = 'X';
    public static final char player_O = 'O';

    private BoardMovements boardMovements;
    private char currentPlayer;

    public TicTacToeGame() {
        boardMovements = new BoardService();
        currentPlayer = player_X;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            boardMovements.printBoard();
            System.out.println("Player " + currentPlayer + ", it's your turn.");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (boardMovements.makeMove(row, col, currentPlayer))
                {
                    if (boardMovements.isWin(currentPlayer))
                        {
                            boardMovements.printBoard();
                            System.out.println("Player " + currentPlayer + " wins!");
                            break;
                        }
                    else if (boardMovements.isDraw())
                        {
                            boardMovements.printBoard();
                            System.out.println("It's a draw!");
                            break;
                        }
                    else
                        {
                            currentPlayer = (currentPlayer == player_X) ? player_O : player_X;
                        }
                }
            else
                {
                    System.out.println("Invalid move! Try again.");
                }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.play();
    }

}
