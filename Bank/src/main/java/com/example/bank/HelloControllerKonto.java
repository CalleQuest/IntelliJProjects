package com.example.bank;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class HelloControllerKonto {

    private Konto konto;
    private Scene scene;
    private FXMLLoader loader;
    private static NumberFormat format = NumberFormat.getCurrencyInstance(Main.getLocale());

    @FXML private TextField txtfieldEin;
    @FXML private TextField txtfieldAus;
    @FXML private Label lblKontostand;
    @FXML private Label lblZinsen;
    @FXML private Label lblTitel;
    @FXML private Label lblKontotxt;
    @FXML private Label lblGuthabtxt;
    @FXML private Button btnEin;
    @FXML private Button btnAus;

    @FXML public void initialize()
    {
        konto = new Konto();
        lblZinsen.textProperty().bindBidirectional(konto.zinsenProperty(), format);
        lblKontostand.textProperty().bindBidirectional(konto.kontostandProperty(), format);
        updateLanguage();
        loader = new FXMLLoader(HelloApplication.class.getResource("kontostand.fxml"));
        try
        {
            scene = new Scene(loader.load(), 600, 350);
        }
        catch(IOException e)
        {
            System.out.println("Fehler");
        }

    }



    public void Einzahlung()
    {
        konto.setKontostandEin(Double.parseDouble(txtfieldEin.getText()));
    }
    public void Auszahlung()
    {
        konto.setKontostandAus(Double.parseDouble(txtfieldEin.getText()));
    }


    public void updateLanguage()
    {
        ResourceBundle resources = ResourceBundle.getBundle("Sprachen", Main.getLocale());
        lblTitel.setText(resources.getString("lblTitel"));
        lblKontotxt.setText(resources.getString("lblKontotxt"));
        lblGuthabtxt.setText(resources.getString("lblGuthabtxt"));
        btnEin.setText(resources.getString("btnEin"));
        btnAus.setText(resources.getString("btnAus"));
    }
    public Scene getScene()
    {
        return scene;
    }
}
