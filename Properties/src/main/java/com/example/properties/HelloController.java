package com.example.properties;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    public static void main(String[] args) {
        Person karl = new Person("Karl","Bronzebart");
        karl.setAlter(50);

        karl.getAlterProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Ausgabe Property: "+ karl.getAlterProperty());
            System.out.println("getAlter Wert: " + karl.getAlter());
            System.out.println("Neuer Wert: "+ newValue);
            System.out.println("Wert v / Property: "+ v);
            System.out.println("Wert oldValue: "+ oldValue);
        });

        karl.setAlter(51);
    }


}