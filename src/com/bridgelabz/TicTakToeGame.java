package com.bridgelabz;

public class TicTakToeGame {
    // board method declaration
    public static void createBoard()
    {
        char[]board = new char[10];
        //loop executes for 9times
        for(int i=1; i<board.length; i++)
        {
            board[i]=' ';  //filling blank spaces in board
        }
    }
    //main method
    public static void main(String[] args) {
        System.out.println("WELCOME TO TIC TAC TOE GAME");
        System.out.println("EMPTY BOARD CREATED");
    }

}
