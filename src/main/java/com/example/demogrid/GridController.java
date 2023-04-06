package com.example.demogrid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class GridController {
    private final GridModel model;
    private final GridView view;

    public GridController(GridModel model, GridView view) {
        this.model = model;
        this.view = view;

        // Add the listener to update the sums whenever a text field changes
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
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
                        updateSums();
                    }
                });
            }
        }
    }

    private void updateSums() {
        // Update the row sums
        for (int row = 0; row < 3; row++) {
            int sum = model.getRowSum(row);
            // boolean checksuma
            view.getRowSumFields()[row].setText(Integer.toString(sum)); // accede al array del getter del view
        }

        // Update the column sums
        for (int col = 0; col < 3; col++) {
            int sum = model.getColumnSum(col);
            view.getColumnSumFields()[col].setText(Integer.toString(sum)); // accede al array del getter del view
        }
    }
}
