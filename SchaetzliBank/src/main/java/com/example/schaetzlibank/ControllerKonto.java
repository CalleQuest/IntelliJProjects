package com.example.schaetzlibank;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerKonto implements Initializable
{
    @FXML
    private Label lKontouebersicht, lKontostandT, lKontostand, lZinsenT, lZinsen;
    @FXML
    private Button bEinzahlen, bAuszahlen;
    @FXML
    private TextField tfEinzahlen, tfAuszahlen;

    private Konto konto;

    private NumberFormat format = NumberFormat.getCurrencyInstance(Localemain.getLocale());


    public void update()
    {

        ResourceBundle resources = ResourceBundle.getBundle("Sprachen2", Localemain.getLocale());
        lKontouebersicht.setText(resources.getString("lKontouebersicht"));
        lKontostandT.setText(resources.getString("lKontostandT"));
        lZinsenT.setText(resources.getString("lZinsenT"));
        bEinzahlen.setText(resources.getString("bEinzahlen"));
        bAuszahlen.setText(resources.getString("bAuszahlen"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            konto = new Konto();
            lKontostand.textProperty().bindBidirectional(konto.kontostandProperty(), format);
            lZinsen.textProperty().bindBidirectional(konto.zinsenProperty(), format);
            update();
    }

    @FXML
    public void einzahlung()
    {
        konto.setKonstand(Double.parseDouble(tfEinzahlen.getText()), true);
        tfEinzahlen.clear();
    }

    @FXML
    public void auszahlung()
    {
        konto.setKonstand(Double.parseDouble(tfAuszahlen.getText()), false);
        tfAuszahlen.clear();
    }



}
