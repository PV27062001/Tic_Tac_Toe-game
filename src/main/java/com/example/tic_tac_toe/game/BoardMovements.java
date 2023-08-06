package com.example.tic_tac_toe.game;

public interface BoardMovements {
    boolean makeMove(int row, int column, char playerSymbol);
    boolean isWin(char playerSymbol);
    boolean isDraw();
    void printBoard();
}
