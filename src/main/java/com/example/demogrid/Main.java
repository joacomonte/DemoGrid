package com.example.demogrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        GridModel model = new GridModel();
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

