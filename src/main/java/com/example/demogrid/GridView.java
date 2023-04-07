package com.example.demogrid;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridView {

    private final int numberOfCells = 4;
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



        // Crear una matriz de objetos TextField de 3x3
        textFields = new TextField[numberOfCells][numberOfCells];
        for (int row = 0; row < numberOfCells; row++) { // loop filas
            for (int col = 0; col < numberOfCells; col++) { //loop Columnas
                TextField textField = new TextField(); // Crear un nuevo objeto TextField para la celda actual
                textField.setAlignment(Pos.CENTER); // Alinear el texto en el centro del campo de texto
                textField.setPrefWidth(60); // Set the preferred width of the text field to 50 pixels
                textField.setPrefHeight(60); // Set the preferred height of the text field to 50 pixels
                textFields[row][col] = textField; // Asignar el objeto TextField a la matriz en la posición actual
                grid.add(textField, col, row); // Agregar el objeto TextField al GridPane en la posición actual
            }
        }



        // Create the text fields for the row sums
        rowSumFields = new TextField[numberOfCells];
        for (int row = 0; row < numberOfCells; row++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setStyle("-fx-background-color: #DDE1E6;");// set background color to light grey
            textField.setAlignment(Pos.CENTER);
            textField.setPrefWidth(60); // Set the preferred width of the text field to 50 pixels
            textField.setPrefHeight(60); // Set the preferred height of the text field to 50 pixels
            rowSumFields[row] = textField;
            grid.add(textField, numberOfCells, row);
        }

        // Create the text fields for the column sums
        columnSumFields = new TextField[numberOfCells];
        for (int col = 0; col < numberOfCells; col++) {
            TextField textField = new TextField();
            textField.setEditable(false);
            textField.setStyle("-fx-background-color: #DDE1E6;"); // set background color to light grey
            textField.setAlignment(Pos.CENTER);
            textField.setPrefWidth(60); // Set the preferred width of the text field to 50 pixels
            textField.setPrefHeight(60); // Set the preferred height of the text field to 50 pixels
            columnSumFields[col] = textField;
            grid.add(textField, col, numberOfCells);
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
