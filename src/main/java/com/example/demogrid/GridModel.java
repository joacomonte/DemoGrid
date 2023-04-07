package com.example.demogrid;

public class GridModel {

    private final int numberOfCells = 4;
    private final int[][] grid;

    private int[][] expectedNumbers;

    public GridModel() {
        grid = new int[numberOfCells][numberOfCells];
    }

    public void setValue(int row, int col, int value) {
        grid[row][col] = value;
    }

    private int[][] rowAndColumNumberGenerator(){
        //initialice list for the desired numbers, it's a 2x4 "grid"
        // expectedNumbers[0][ROW]   and   expectedNumbers[1][COLUMN]
        int[][] expectedNumbers = new int[numberOfCells/2][numberOfCells];
        //TODO Generate the numbers, must follow some math rules. not an easy task
        return expectedNumbers;
    }

    public void setExpectedNumbers(int[][] expectedNumbers){
        //TODO using rowAndColumNumberGenerator we must make this method to set the numbers on the non-editable cells
        this.expectedNumbers = expectedNumbers;
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

    public int getRowDesireNumber(int row) {
        return expectedNumbers[0][row];
    }

    public boolean isRowSumAchieved(int sum, int desiredSum) {
        return (sum == desiredSum);
    }
}
