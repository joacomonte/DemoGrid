package com.example.demogrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        //Creating model, randomNumbers, view and controller
        GridModel model = new GridModel();
        model.generateRandomResults();
        GridView view = new GridView();
        new GridController(model, view);

        Scene scene = new Scene(view.getGrid(), 400, 400);
        primaryStage.setTitle("Grid Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

