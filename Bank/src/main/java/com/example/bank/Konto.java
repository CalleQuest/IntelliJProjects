package com.example.bank;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;

public class Konto {
    private DoubleProperty kontostand = new SimpleDoubleProperty(5000);
    private DoubleProperty zinsen = new SimpleDoubleProperty(20);
    private double zinssatz = 0.02;

    public Konto()
    {
        zinsen.bind(kontostand.multiply(zinssatz));
    }

    public DoubleProperty kontostandProperty() {
        return kontostand;
    }

    public DoubleProperty zinsenProperty() {
        return zinsen;
    }

    public double getKontostand() {
        return kontostand.get();
    }

    public double getZinsen() {
        return zinsen.get();
    }

    public void setKontostandEin(double wert)
    {
        kontostand.setValue(kontostand.getValue()+wert);
    }

    public void setKontostandAus(double wert)
    {
        kontostand.setValue(kontostand.getValue()-wert);
    }
}
