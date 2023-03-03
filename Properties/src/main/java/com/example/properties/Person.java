package com.example.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Person {
    private String vorname;
    private String nachname;
    private IntegerProperty alter = new SimpleIntegerProperty(this, "Alter",0);

    //Gibt Integerproperty Objekt zurück
    public IntegerProperty getAlterProperty()
    {
        return alter;
    }
    //Gibt den wert also Alter aus. Vom IntegerProperty
    public int getAlter() {
        return alter.get();
    }

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }



    public void setAlter(int alter) {
        this.alter.set(alter);
    }
}
