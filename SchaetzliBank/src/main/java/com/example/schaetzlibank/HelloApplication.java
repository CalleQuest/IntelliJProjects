package com.example.schaetzlibank;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloApplication extends Application {

    private static Scene scene1;
    private static Scene scene2;
    private static Stage stage1;

    public static void setScene2(Scene test) {
        scene2 = test;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BankLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage1 = stage;
        scene1 = scene;

    }

    public static Stage getStage1()
    {
        return stage1;
    }

    public static void switchScene()
    {
        stage1.setScene(scene2);
    }

    public static void main(String[] args)
    {
        launch();
    }


}