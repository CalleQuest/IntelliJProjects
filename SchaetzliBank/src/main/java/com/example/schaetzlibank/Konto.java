package com.example.schaetzlibank;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Konto
{
    private DoubleProperty kontostand = new SimpleDoubleProperty();
    private DoubleProperty zinsen = new SimpleDoubleProperty();

    private NumberBinding ergebnis;
    private double zinssatz = 0.02;


    public Konto()
    {
        kontostand.setValue(1000.00);
        zinsen.setValue(20);
        ergebnis = Bindings.multiply(kontostand,zinssatz);
        zinsen.bind(ergebnis);
    }


    public DoubleProperty kontostandProperty()
    {
        return kontostand;
    }

    public DoubleProperty zinsenProperty()
    {
        return zinsen;

    }

    public Double getZinsen()
    {
        return zinsen.get();
    }

    public void setZinsen(double test)
    {
        this.zinsenProperty().set(test);
        System.out.println(test);
    }

    public Double getKontostand()
    {
        return kontostand.get();
    }



    public void setKonstand(double wert, boolean test)
    {
        if (test == true) {

            this.kontostand.set(kontostand.get() + wert);


        }
        else {
            this.kontostand.set(kontostand.get() - wert);

        }
    }
}
