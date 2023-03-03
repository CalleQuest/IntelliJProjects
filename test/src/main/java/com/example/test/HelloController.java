package com.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    private static Locale locale;
    @FXML
    public void initialize()
     {
         setup();
     }
    @FXML
    private Button btnReset;
    @FXML
    private Button btnResetAll;
    @FXML
    private Button btnBerech;
    @FXML
    private TextField zahl1;
    @FXML
    private Label title;
    @FXML
    private TextField zahl2;
    @FXML
    private Label lblErgebnis;
    @FXML
    private ListView rechnungen;
    @FXML
    private ComboBox operatoren;
    @FXML
    private ComboBox comboLanguage;
    @FXML
    private void auswahl(ActionEvent event)
    {
        int sprache = comboLanguage.getSelectionModel().getSelectedIndex();
        switch(sprache)
        {
            case 0:
                setLocale(new Locale("de","DE"));
                ResourceBundle.getBundle("Sprachen",getLocale());
                break;
            case 1:
                setLocale(new Locale("en","EN"));
                ResourceBundle.getBundle("Sprachen",getLocale());
            case 2:
                setLocale(new Locale("jp","JP"));
                ResourceBundle.getBundle("Sprachen",getLocale());
            updateUI();
        }
    }

    public static Locale getLocale()
    {
        if (locale == null)
        {
            locale = new Locale("de","DE");
        }
        return locale;
    }

    private void updateUI()
    {
        ResourceBundle resources = ResourceBundle.getBundle("Sprachen", getLocale());
        btnBerech.setText(resources.getString("btnBerech"));
        title.setText(resources.getString("title"));
        btnReset.setText("btnReset");
        btnResetAll.setText("btnResetAll");

    }
    public static void setLocale (Locale newLocale)
    {
        locale = newLocale;
    }
    public void setup()
    {

        comboLanguage.getItems().addAll("German","English","Japanese");
        operatoren.getItems().addAll("+","-","*","/");

    }
    public void resetall()
    {
        zahl1.setText("");
        zahl2.setText("");
        rechnungen.getItems().clear();
        lblErgebnis.setText("");
    }

    public void reset()
    {
        zahl1.setText("");
        zahl2.setText("");
        lblErgebnis.setText("");
    }

    public void berechnen()
    {
        double dzahl1 = Double.parseDouble(zahl1.getText());
        double dzahl2 = Double.parseDouble(zahl2.getText());
        double dErgebnis = 0;
        if(operatoren.getValue().equals("+"))
        {
            dErgebnis = dzahl1 + dzahl2;
        }
        else if (operatoren.getValue().equals("-"))
        {
            dErgebnis = dzahl1 - dzahl2;
        }
        else if (operatoren.getValue().equals("/"))
        {
            dErgebnis = dzahl1 / dzahl2;
        }
        else if (operatoren.getValue().equals("*"))
        {
            dErgebnis = dzahl1 * dzahl2;
        }
       // ergebnis.setText(Integer.toString(iergebnis));
        lblErgebnis.setText(Double.toString(dErgebnis));

        historyAdd(Double.toString(dzahl1),Double.toString(dzahl2),Double.toString(dErgebnis),(String)operatoren.getValue());

    }

    public void historyAdd(String zahl1, String zahl2, String ergeb, String operat)
    {
        String history = zahl1 +" "+operat+" "+zahl2+"  = "+ ergeb;

        rechnungen.getItems().addAll(history);
    }




}