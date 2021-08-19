package com.bridgelabz;

import java.util.Scanner;

/**
 * Program for checking free space before making desired move
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
        //calling method to make a move to a desired location in board by the user
        userPlay();

    }

    /**
     * Creating method for empty board
     */
    private static void createBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
    }

    /**
     * Asking user to choose X or O
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
     * displaying the current game board
     * creating method for show current board
     */
    public static void showBoard() {
        // 0th index
        System.out.println("TIC TAC TOE GAME BOARD");
        System.out.println(board[1] + " |" + board[2] + " |" + board[3]);
        System.out.println("--+--+--");
        System.out.println(board[4] + " |" + board[5] + " |" + board[6]);
        System.out.println("--+--+--");
        System.out.println(board[7] + " |" + board[8] + " |" + board[9]);

    }

    // method makes move to location given by user
    static void userPlay() {
        System.out.println("Enter board index(1-9) to set your game move ");
        Scanner sc = new Scanner(System.in);
        int userMove = sc.nextInt();
        switch (userMove) {
            case 1:
                if (board[1] == ' ') {
                    board[1] = userLetter;
                }
                break;
            case 2:
                if (board[2] == ' ') {
                    board[2] = userLetter;
                }
                break;
            case 3:
                if (board[3] == ' ') {
                    board[3] = userLetter;
                }
                break;
            case 4:
                if (board[4] == ' ') {
                    board[4] = userLetter;
                }
                break;
            case 5:
                if (board[5] == ' ') {
                    board[5] = userLetter;
                }
                break;
            case 6:
                if (board[6] == ' ') {
                    board[6] = userLetter;
                }
                break;
            case 7:
                if (board[7] == ' ') {
                    board[7] = userLetter;
                }
                break;
            case 8:
                if (board[8] == ' ') {
                    board[8] = userLetter;
                }
                break;
            case 9:
                if (board[9] == ' ') {
                    board[9] = userLetter;
                }
                break;
            default:
                System.out.println("Invalid Move");
        }
        showBoard();
    }

    /**
     * This method checks for free space for the computer to make the move
     */
    static void computerPlay() {
        // generates move for computer using random function
        // while loop runs until flag true, flag becomes false on making a move
        boolean played = false;
        while (!played) {
            int playMove = (int) (Math.random() * 10) % 9 + 1;
            if (playMove > 0 && playMove < 10) {
                if (board[playMove] == ' ') {
                    board[playMove] = computerLetter;
                    played = true;
                }
            }
        }
        showBoard();
    }

    // method to check for starting player through coin toss result

    static void toss() {
        int turn = (int) Math.floor(Math.random() * 10) % 2;
        System.out.println("To start the game enter 1 to play the toss: ");
        Scanner sc = new Scanner(System.in);
        int playerToss = sc.nextInt();
        if (playerToss == turn) {
            System.out.println("Player won the toss, enter your first Move");
            userPlay();
            computerPlay();

        } else {
            System.out.println("Computer won the toss, enter your first move");
            computerPlay();
            userPlay();

        }

    }

    // method to check for wining player
    public static char playerWon(char[] board) {
        int[][] game = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 5, 9}, {3, 5, 7}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        char won = 'W';
        for (int i = 0; i < game.length; i++) {
            if (board[game[i][0]] == board[game[i][1]] && board[game[i][1]] == board[game[i][2]]) {
                if (board[game[i][0]] != ' ') {
                    won = board[game[i][0]];
                    break;
                }
            }
        }
        return won;
    }

    // method to check for empty spaces on game board
    public static boolean isBoardFilled(char[] board) {
        boolean filled = true;
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                filled = false;
                break;
            }
        }
        return filled;
    }

    // method to check game state
    public static char getGameState(char[] board, char user, char computer, char current) {
        char won = playerWon(board);
        char tie = ' ', state = ' ';
        if (current == user) {
            tie = computer;
        } else {
            tie = user;
        }
        switch (won) {
            case 'F':
                state = tie;
                break;
            case 'X':
                System.out.println("X has won the game");
                state = 'E';
                break;
            case 'O':
                System.out.println("O has won the game");
                state = 'E';
                break;
        }
        if (isBoardFilled(board)) {
            state = 'E';
        }
        return state;
    }

    // calculates wining position for computer
    public static int winningPosition(char userChoice, char[] board) {
        int[][] game = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 5, 9}, {3, 5, 7}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int place = -1;
        for (int i = 0; i < game.length; i++) {
            if (board[game[i][0]] == userChoice &&
                    board[game[i][0]] == board[game[i][1]] &&
                    board[game[i][2]] == ' ') {
                if (board[game[i][0]] != ' ') {
                    place = game[i][2];
                }
            }
            if (board[game[i][0]] == userChoice &&
                    board[game[i][0]] == board[game[i][2]] &&
                    board[game[i][1]] == ' ') {
                if (board[game[i][0]] != ' ') {
                    place = game[i][1];
                }
            }
            if (board[game[i][1]] == userChoice &&
                    board[game[i][1]] == board[game[i][2]] &&
                    board[game[i][0]] == ' ') {
                if (board[game[i][1]] != ' ') {
                    place = game[i][0];
                }
            }
        }
        return place;
    }

    // generates move for computer to blocks if losing game

    static void computerSmartPlay() {
        int[] border = {1, 3, 7, 9};
        int[] center = {2, 4, 6, 8};
        int placeWin = winningPosition(computerLetter, board);
        int losing = winningPosition(userLetter, board);
        if (losing != -1) {
            board[losing] = computerLetter;
        } else if (placeWin != -1) {
            board[placeWin] = computerLetter;
        } else if (losing == -1 && placeWin == -1) {
            for (int i = 0; i < border.length; i++) {
                if (board[border[i]] == ' ') {
                    board[border[i]] = computerLetter;
                    break;
                }
            }
        } else {
            if (board[5] == ' ') {
                board[5] = computerLetter;
            } else {
                for (int i = 0; i < center.length; i++) {
                    if (board[center[i]] == ' ') {
                        board[center[i]] = computerLetter;
                        break;
                    }
                }
            }
        }
        showBoard();
    }

    // play game until end
    public static void playTillEnd(char playerLetter, char[] board, char computerLetter) {
        char start = userLetter;
        if (start == playerLetter) {
            System.out.println("Player wins coin toss, start first");
        } else {
            System.out.println("Player loses coin toss, computer starts first");
        }
        char gameState = start;
        while (gameState != 'E') {
            if (gameState == playerLetter) {
                userPlay();
                gameState = getGameState(board, playerLetter, computerLetter, gameState);
            }
            if (gameState == computerLetter) {
                computerPlay();
                gameState = getGameState(board, playerLetter, computerLetter, gameState);
            }
        }
    }

}
