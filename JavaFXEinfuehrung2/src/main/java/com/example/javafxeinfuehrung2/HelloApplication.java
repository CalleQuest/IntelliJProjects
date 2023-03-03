package com.example.javafxeinfuehrung2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage primaryStage = new Stage();
        Stage secondaryStage = new Stage();
        Scene scene1, scene2, scene2window;

        Button btnMoveNextScene = new Button("Nächste Scene");
        Button btnMovePreviousScene = new Button("Vorherige Scene");
        Button btnMoveNewStage = new Button("Neue Stage");

        StackPane scene1pane = new StackPane();
        scene1pane.getChildren().add(btnMoveNextScene);
        scene1 = new Scene(scene1pane, 300 ,250);

        StackPane scene2pane = new StackPane();
        scene2pane.getChildren().add(btnMovePreviousScene);
        scene2 = new Scene(scene2pane, 300, 250);

        StackPane stage2pane = new StackPane();
        stage2pane.getChildren().add(btnMovePreviousScene);
        scene2window = new Scene (stage2pane, 100, 100);



        btnMoveNextScene.setOnAction(e -> primaryStage.setScene(scene2));

        primaryStage.setTitle("First Window");
        primaryStage.setScene(scene1);
        primaryStage.show();

        secondaryStage.setTitle("Second Window");
        secondaryStage.setScene(scene2);

        btnMoveNewStage.setOnAction(e -> secondaryStage.show());



    }


    public static void main(String[] args) {
        launch();
    }
}