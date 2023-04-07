package com.example.demogrid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class GridController {

    private final int numberOfCells = 4;
    private final GridModel model;
    private final GridView view;

    public GridController(GridModel model, GridView view) {
        this.model = model;
        this.view = view;

        // Add the listener to update the sums whenever a text field changes
        for (int row = 0; row < numberOfCells; row++) {
            for (int col = 0; col < numberOfCells; col++) {
                TextField textField = view.getTextFields()[row][col];
                int finalRow = row;
                int finalCol = col;
                textField.textProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        int value = 0;
                        try {
                            value = Integer.parseInt(newValue);
                        } catch (NumberFormatException e) {
                            value = 0;
                        }
                        model.setValue(finalRow, finalCol, value);
                        setDesiredNumberCell();
                        checkWinCondition();
                    }
                });
            }
        }
        // it prints desired sums at first render
        setDesiredNumberCell();
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
        for (int col = 0; col < numberOfCells; col++) {
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
        for (int row = 0; row < numberOfCells; row++) {
            int sum = model.getRowSum(row);
            int desiredSum = model.getRowDesireNumber(row);
            boolean rowSumAchieved = model.isRowSumAchieved(sum, desiredSum);
            sumAcumulator = sumAcumulator || rowSumAchieved;
        }
        return sumAcumulator;
    }

    private void setDesiredNumberCell(){
        for (int row = 0; row < numberOfCells; row++){
            int desiredNumber = model.getRowDesireNumber(row);
            view.getRowSumFields()[row].setText(Integer.toString(desiredNumber));
        }
        for (int col = 0; col < numberOfCells; col++){
            int desiredNumber = model.getColumnDesireNumber(col);
            view.getColumnSumFields()[col].setText(Integer.toString(desiredNumber));
        }
    }
    //this method is probably deprecated
    private void updateSums() {
        // Update the row sums
        for (int row = 0; row < numberOfCells; row++) {
            int sum = model.getRowDesireNumber(row);

            // boolean checksum
            view.getRowSumFields()[row].setText(Integer.toString(sum)); // accede al array del getter del view
        }

        // Update the column sums
        for (int col = 0; col < numberOfCells; col++) {
            int sum = model.getColumnDesireNumber(col);
            view.getColumnSumFields()[col].setText(Integer.toString(sum)); // accede al array del getter del view
        }
    }
}
