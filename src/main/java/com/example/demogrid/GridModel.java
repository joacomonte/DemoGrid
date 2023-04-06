package com.example.demogrid;

public class GridModel {
    private final int[][] grid;

    public GridModel() {
        grid = new int[3][3];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

//    public int getValue(int row, int col) {
//        return grid[row][col];
//    }

    public int getRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < 3; col++) {
            sum += grid[row][col];
        }
        return sum;
    }

    public int getColumnSum(int col) {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            sum += grid[row][col];
        }
        return sum;
    }
}
