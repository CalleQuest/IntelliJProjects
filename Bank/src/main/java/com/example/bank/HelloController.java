package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    private int counter;
    private String username = "Calvin";
    private String password = "orangensaft";
    @FXML
    public void initialize(){starter();}
    @FXML
    private TextField uEingabe;
    @FXML
    private TextField pEingabe;
    @FXML
    private ComboBox comboSprache;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblWelcome;
    @FXML
    private Label lblPass;
    @FXML Label lblUser;
    @FXML
    private Label lblSprache;

    @FXML
    public void logcheck()
    {
        if (uEingabe.getText().equals(username) && pEingabe.getText().equals(password))
        {
          System.out.println("Erfolgreich eingeloggt");
          HelloApplication.toScene2();
        }
        else if (counter<3)
        {
            System.out.println("falsches passwort");
            counter++;
        }
        else
        {
            System.out.println("Du wurdest ausgesperrt");
        }
    }
    public void starter()
    {
        comboSprache.getItems().addAll("Deutsch","Englisch","Spanisch");
    }
    @FXML
    private void auswahl() {
        int sprache = comboSprache.getSelectionModel().getSelectedIndex();
        switch (sprache) {
            case 0:
                Main.setLocale(new Locale("de", "DE"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;
            case 1:
                Main.setLocale(new Locale("en", "EN"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;
            case 2:
                Main.setLocale(new Locale("es", "ES"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;
        }
        updateUI();
    }


    private void updateUI() {
        ResourceBundle resources = ResourceBundle.getBundle("Sprachen", Main.getLocale());
        btnLogin.setText(resources.getString("btnLogin"));
        lblWelcome.setText(resources.getString("lblWelcome"));
        lblSprache.setText(resources.getString("lblSprache"));
        lblUser.setText(resources.getString("lblUser"));
        lblPass.setText(resources.getString("lblPass"));

    }
}