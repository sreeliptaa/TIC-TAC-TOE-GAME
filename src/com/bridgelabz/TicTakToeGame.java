package com.bridgelabz;

/**
 * Program for TicTacToe Game playing with computer
 * @author Sreelipta
 * @since 2021-08-11
 */
public class TicTacToeGame {

    static char[] board = new char[10];

    public static void main(String[] args) {
        //displaying welcome message
        System.out.println("Welcome to Tic Tac Toe Game");
        //calling method to initialise the board
        createBoard();
    }

    /**
     * Creating method for empty board
     * 0th index is ignored
     */
    private static void createBoard() {

        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }
}
