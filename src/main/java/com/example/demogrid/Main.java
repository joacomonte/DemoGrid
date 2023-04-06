package com.example.demogrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        int [] array = {1,2,3};
        GridModel model = new GridModel(array);
        GridView view = new GridView();
        GridController controller = new GridController(model, view);

        Scene scene = new Scene(view, 400, 400);
        primaryStage.setTitle("Demo Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

