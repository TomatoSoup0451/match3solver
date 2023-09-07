package com.tomatosoup;

import com.tomatosoup.model.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 6);
        board.initialiseRandom();
        board.print();
        System.out.println();
        for (int i = 0; i < board.getHeight(); i++){
            board.checkBoard();
        }
        board.print();
    }
}