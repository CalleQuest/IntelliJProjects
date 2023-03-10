package com.example.bank;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class HelloControllerKonto {

    private Konto konto;
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

}
