package com.example.demogrid;

public class GridModel {

    private final int numberOfCells = 4;
    private final int[][] grid;

    public GridModel() {
        grid = new int[numberOfCells][numberOfCells];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

//    public int getValue(int row, int col) {
//        return grid[row][col];
//    }

    public int getRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < numberOfCells; col++) {
            sum += grid[row][col];
        }
        return sum;
    }

    public int getColumnSum(int col) {
        int sum = 0;
        for (int row = 0; row < numberOfCells; row++) {
            sum += grid[row][col];
        }
        return sum;
    }
}
