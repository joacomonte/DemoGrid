package com.example.demogrid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class GridController {

    private final int gridSize = 4;
    private final GridModel model;
    private final GridView view;

    public GridController(GridModel model, GridView view) {
        this.model = model;
        this.view = view;

        // Add the listener to update the sums whenever a text field changes
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                TextField textField = view.getTextFields()[row][col];
                int finalRow = row;
                int finalCol = col;
                textField.textProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int value = 0;
                        try {
                            value = Integer.parseInt(newValue);
                        } catch (NumberFormatException e) {
                            // ignore invalid input
                        }
                        model.setValue(finalRow, finalCol, value);
                        checkWinCondition();
                    }
                });
            }
        }
        // it prints desired sums at first render (only runs once)
        setExpectedSumsIntoGrid();
    }

    private void checkWinCondition() {
        //gets the sum of row, and the desired rowSum. then probably needs to be compared from model
        boolean allRowSumAchieved = allRowSumAchieved();
        boolean allColumnSumAchieved = allColumnSumAchieved();
        if(allColumnSumAchieved==allRowSumAchieved){
            //TODO WIN!
        }

    }

    //check if all the column sums are OK.
    private boolean allColumnSumAchieved() {
        boolean sumAcumulator = false;
        for (int col = 0; col < gridSize; col++) {
            int sum = model.getRowSum(col);
            int desiredSum = model.getColumnDesireNumber(col);
            boolean rowSumAchieved = model.isColSumAchieved(sum, desiredSum);
            sumAcumulator = sumAcumulator || rowSumAchieved;
        }
        return sumAcumulator;
    }

    //check if all the row sums are OK.
    private boolean allRowSumAchieved() {
        boolean sumAcumulator = false;
        for (int row = 0; row < gridSize; row++) {
            int sum = model.getRowSum(row);
            int desiredSum = model.getRowDesireNumber(row);
            boolean rowSumAchieved = model.isRowSumAchieved(sum, desiredSum);
            sumAcumulator = sumAcumulator || rowSumAchieved;
        }
        return sumAcumulator;
    }

    private void setExpectedSumsIntoGrid(){
        for (int row = 0; row < gridSize; row++){
            //gets from model
            int expectedRowSum = model.getRowDesireNumber(row);
            //sets into view
            view.getRowSumFields()[row].setText(Integer.toString(expectedRowSum));
        }
        for (int col = 0; col < gridSize; col++){
            //gets from model
            int expectedColSum = model.getColumnDesireNumber(col);
            //sets into view
            view.getColumnSumFields()[col].setText(Integer.toString(expectedColSum));
        }
    }
}
