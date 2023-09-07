package com.tomatosoup.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Board {
    private final int width;
    private final int height;
    private final Tile[][] board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        board = new Tile[height][width];
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void initialiseRandom() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Tile(Tile.TileType.values()[ThreadLocalRandom.current().nextInt(0, 5)]);
            }
        }
    }

    public void checkBoard() {
        for (int i = 0; i < getHeight(); i++) {
            checkRow(i);
        }
        for (int i = 0; i < getWidth(); i++) {
            checkColumn(i);
        }
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j].isToBeCleared()) {
                    board[i][j].setType(Tile.TileType.EMPTY);
                }
                ;
            }
        }
    }

    public boolean checkColumn(int columnNumber) {
        boolean result = false;
        Tile tile = board[0][columnNumber];
        int count = 1;
        int index = 0;
        for (int i = 1; i < height; i++) {
            Tile current = board[i][columnNumber];
            if (!tile.equals(current)) {
                if (count < 3) {
                    count = 1;
                    tile = current;
                    index = i;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        if (count >= 3) {
            result = true;
            for (int i = 0; i < count; i++) {
                board[i + index][columnNumber].setToBeCleared(true);
            }
        }
        return result;
    }

    public boolean checkRow(int rowNumber) {
        boolean result = false;
        Tile tile = board[rowNumber][0];
        int count = 1;
        int index = 0;
        for (int i = 1; i < width; i++) {
            Tile current = board[rowNumber][i];
            if (!tile.equals(current)) {
                if (count < 3) {
                    count = 1;
                    tile = current;
                    index = i;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        if (count >= 3) {
            result = true;
            for (int i = 0; i < count; i++) {
                board[rowNumber][i + index].setToBeCleared(true);
            }
        }
        return result;
    }
}
