package com.example.demogrid;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridView extends GridPane {
    private final TextField[][] textFields = new TextField[5][5];

    public GridView() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10, 10, 10, 10));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                textFields[i][j] = new TextField();
                add(textFields[i][j], j, i);
            }
        }
    }

    public void update(GridModel model) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                textFields[i-1][j-1].setText(Integer.toString(model.getValue((i-1)*5+j)));
            }
        }
    }
}
