package com.example.bank;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloControllerKonto {

    DecimalFormat df = new DecimalFormat("#.00");
    private DoubleProperty kontostand = new SimpleDoubleProperty(5000);
    private DoubleProperty zinsen = new SimpleDoubleProperty(20);

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
        lblZinsen.setText(String.valueOf(zinsen.get()));
        lblKontostand.setText(String.valueOf(kontostand.get()));
        updateLanguage();
        zinsen.bind(kontostand.multiply(0.01));

    }

    public void Einzahlung()
    {

        kontostand.setValue(kontostand.getValue() + Double.parseDouble(txtfieldEin.getText()));
        updateUI();
    }
    public void Auszahlung()
    {
        kontostand.setValue(kontostand.getValue() - Double.parseDouble(txtfieldAus.getText()));
        updateUI();
    }
    public void updateUI()
    {
        lblZinsen.setText(String.valueOf(df.format(zinsen.get())));
        lblKontostand.setText(String.valueOf(df.format(kontostand.get())));
    }

    public void updateLanguage()
    {
        ResourceBundle resources = ResourceBundle.getBundle("Sprachen", HelloController.getLocale());
        lblTitel.setText(resources.getString("lblTitel"));
        lblKontotxt.setText(resources.getString("lblKontotxt"));
        lblGuthabtxt.setText(resources.getString("lblGuthabtxt"));
        btnEin.setText(resources.getString("btnEin"));
        btnAus.setText(resources.getString("btnAus"));
    }

}
