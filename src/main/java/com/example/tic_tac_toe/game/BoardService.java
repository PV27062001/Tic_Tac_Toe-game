package com.example.tic_tac_toe.game;

import org.springframework.stereotype.Service;

import static com.example.tic_tac_toe.game.TicTacToeGame.player_O;
import static com.example.tic_tac_toe.game.TicTacToeGame.player_X;

@Service
public class BoardService implements BoardMovements{
    private static final int boardSize = 3;
    private char[][] board;
    public BoardService() {
        board = new char[boardSize][boardSize];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                board[row][column] = ' ';
            }
        }
    }

    @Override
    public boolean makeMove(int row, int column, char playerSymbol) {
        if (row < 0 || row >= boardSize || column < 0 || column >= boardSize || board[row][column] != ' ') {
            return false; // Move is invalid
        }
        board[row][column] = playerSymbol;
        return true;
    }

    @Override
    public boolean isWin(char playerSymbol) {
        // Check rows, columns, and diagonals for a win
        for (int index = 0; index < boardSize; index++) {
            // Check rows
            if (board[index][0] == playerSymbol && board[index][1] == playerSymbol && board[index][2] == playerSymbol) {
                return true;
            }

            // Check columns
            if (board[0][index] == playerSymbol && board[1][index] == playerSymbol && board[2][index] == playerSymbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) {
            return true; // Diagonal win (top-left to bottom-right)
        }

        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    @Override
    public boolean isDraw() {
        // If there are no empty cells and there is no win, it's a draw
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                if (board[row][column] == ' ') {
                    return false; // There is an empty cell, the game is not a draw yet
                }
            }
        }
        return !isWin(player_X) && !isWin(player_O);
    }

    @Override
    public void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < boardSize; row++) {
            System.out.print("| ");
            for (int column = 0; column < boardSize; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
