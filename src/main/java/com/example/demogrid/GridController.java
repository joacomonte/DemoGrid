package com.example.demogrid;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GridController {

    @FXML
    private final GridView gridView;

    private final GridModel gridModel;
    @FXML
    private TextField indexField;

    @FXML
    private TextField valueField;

    @FXML
    private Button updateButton;

    public GridController(GridModel model, GridView view) {
        this.gridModel = model;
        this.gridView = view;
    }

    @FXML
    public void initialize() {
        gridView.update(gridModel);
    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        int index = Integer.parseInt(indexField.getText());
        int value = Integer.parseInt(valueField.getText());
        gridModel.setValue(index, value);
        gridView.update(gridModel);
    }
}
