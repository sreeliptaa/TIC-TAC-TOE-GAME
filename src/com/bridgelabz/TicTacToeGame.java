package com.bridgelabz;

import java.util.Scanner;

/**
 * Program for TicTacToe Game playing with computer
 * @author Sreelipta
 * @since 2021-08-11
 */
public class TicTacToeGame {
    static char[] board = new char[10];
    static char userLetter, computerLetter;

    public static void main(String[] args) {
        //displaying welcome message
        System.out.println("Welcome to Tic Tac Toe Game");
        //calling method to initialise the board
        createBoard();
        //calling method for user to choose 'X' or 'O' mark
        choosingXorO();
        //calling method to show the current board
        showBoard();
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

    /**
     * Asking user to choose X or O
     *
     * @return userLetter, computerLetter
     */
    private static void choosingXorO() {
        System.out.println("Choose letter X or O to play game");
        Scanner sc = new Scanner(System.in);
        userLetter = sc.next().toUpperCase().charAt(0);
        switch (userLetter) {
            case 'X':
                System.out.println("Player Plays with : X letter");
                System.out.println("Computer Plays with : O letter");
                computerLetter = 'O';
                break;
            case 'O':
                System.out.println("Player Plays with : O letter");
                System.out.println("Computer Plays with : X letter");
                computerLetter = 'X';
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }
    }

    /**
     * display the current game board
     * creating method for show current board
     */
    public static void showBoard() {
        // 0th index ignored
        System.out.println("TIC TAC TOE GAME BOARD");
        System.out.println(board[1] + " |" + board[2] + " |" + board[3]);
        System.out.println("--+--+--");
        System.out.println(board[4] + " |" + board[5] + " |" + board[6]);
        System.out.println("--+--+--");
        System.out.println(board[7] + " |" + board[8] + " |" + board[9]);
    }
}









