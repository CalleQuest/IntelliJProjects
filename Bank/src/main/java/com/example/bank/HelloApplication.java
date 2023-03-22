package com.example.bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.bank.HelloController.scene;

public class HelloApplication extends Application {

    static Stage stage;
    private static HelloController controllerLogin;
    private static HelloControllerKonto controllerKonto;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //controllerLogin.getScene() = new Scene(fxmlLoader.load(), 600, 350);
        stage.setTitle("Kontologin");
        stage.setScene(controllerLogin.getScene());
        stage.show();

        //2te scene laden
        //FXMLLoader loader2 = new FXMLLoader(HelloApplication.class.getResource("kontostand.fxml"));
        //scene2 = new Scene(loader2.load(),600,350);

    }
    public static void toScene2()
    {
        stage.setScene(controllerKonto.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}