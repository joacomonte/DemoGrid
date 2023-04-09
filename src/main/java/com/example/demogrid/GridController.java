package com.example.demogrid;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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
                        checkWinConditionAndPaint();
                    }
                });
            }
        }
        // it prints desired sums at first render (only runs once)
        setExpectedSumsIntoGrid();
    }

    private void checkWinConditionAndPaint() {
        boolean rowsOk = checkAllRowsSumExpectedResult();
        boolean colsOk = checkAllColumnsSumExpectedResult();

        // paint cells based on the condition
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                TextField textField = view.getTextFields()[row][col];
                if (model.getRowSum(row) == model.getRowDesireNumber(row)) {
                    textField.setStyle("-fx-background-color: #90ee90;"); // set background color to light green
                } else if (model.getColumnSum(col) == model.getColumnDesireNumber(col)) {
                    textField.setStyle("-fx-background-color: #90ee90;"); // set background color to light green
                } else {
                    textField.setStyle(""); // set background color to white
                }
            }
        }

        // check if all the row sums and column sums are achieved and print a message if so
        if (rowsOk && colsOk && checkAllRowsSumExpectedResult() && checkAllColumnsSumExpectedResult()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("FELICITACIONES");
            alert.setHeaderText("GANASTE :D");
            alert.setContentText("Aprieta Ok para reiniciar el juego ");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }



    private boolean checkAllColumnsSumExpectedResult() {
        boolean sumAcumulator = true; // initialize with true
        for (int col = 0; col < gridSize; col++) {
            int sum = model.getColumnSum(col); // use getColumnSum() method here
            int desiredSum = model.getColumnDesireNumber(col);
            boolean colSumAchieved = model.isColSumAchieved(sum, desiredSum);
            sumAcumulator = sumAcumulator && colSumAchieved; // use && operator here
        }
        return sumAcumulator;
    }

    private boolean checkAllRowsSumExpectedResult() {
        boolean sumAcumulator = true; // initialize with true
        for (int row = 0; row < gridSize; row++) {
            int sum = model.getRowSum(row);
            int desiredSum = model.getRowDesireNumber(row);
            boolean rowSumAchieved = model.isRowSumAchieved(sum, desiredSum);
            sumAcumulator = sumAcumulator && rowSumAchieved; // use && operator here
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
