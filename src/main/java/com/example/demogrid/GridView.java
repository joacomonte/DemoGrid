package com.example.demogrid;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GridView {
    private final GridPane grid;
    private final TextField[][] textFields;
    private final TextField[] rowSumFields;
    private final TextField[] columnSumFields;

    public GridView() {

        // Crear el contenedor GridPane
        grid = new GridPane();

        // alinea grid al centro
        grid.setAlignment(Pos.CENTER);

        // in-grid padding horizontal
        grid.setHgap(10);

        // in-grid padding vertical
        grid.setVgap(10);

       // grid padding
        grid.setPadding(new Insets(25, 25, 25, 25));




        textFields = new TextField[3][3]; // Crear una matriz de objetos TextField de 3x3
        for (int row = 0; row < 3; row++) { // loop filas
            for (int col = 0; col < 3; col++) { //loop Columnas
                TextField textField = new TextField(); // Crear un nuevo objeto TextField para la celda actual
                textField.setAlignment(Pos.CENTER); // Alinear el texto en el centro del campo de texto
                textFields[row][col] = textField; // Asignar el objeto TextField a la matriz en la posición actual
                grid.add(textField, col, row); // Agregar el objeto TextField al GridPane en la posición actual
            }
        }


        // Create the text fields for the row sums
        rowSumFields = new TextField[3];
        for (int row = 0; row < 3; row++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setAlignment(Pos.CENTER);
            rowSumFields[row] = textField;
            grid.add(textField, 3, row);
        }

        // Create the text fields for the column sums
        columnSumFields = new TextField[3];
        for (int col = 0; col < 3; col++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setAlignment(Pos.CENTER);
            columnSumFields[col] = textField;
            grid.add(textField, col, 3);
        }
    }

    public GridPane getGrid() {
        return grid;
    }

    public TextField[][] getTextFields() {
        return textFields;
    }

    public TextField[] getRowSumFields() {
        return rowSumFields;
    }

    public TextField[] getColumnSumFields() {
        return columnSumFields;
    }
}
