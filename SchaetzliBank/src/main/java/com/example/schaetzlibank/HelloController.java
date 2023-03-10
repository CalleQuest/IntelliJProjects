package com.example.schaetzlibank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button blogin;
    @FXML
    private ComboBox cblanguage;
    @FXML
    private Label lwelcome, lUser, lPassword;
    @FXML
    private TextField tfuser;
    @FXML
    private PasswordField lpasswordF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cblanguage.getItems().addAll("Deutsch", "Englisch", "Französisich");
        cblanguage.getSelectionModel().selectFirst();
        updateUI();
    }

    @FXML
    public void auswahl(ActionEvent e)
    {
        int sprache = cblanguage.getSelectionModel().getSelectedIndex();
        switch (sprache)
        {
            case 0:
                Main.setLocale(new Locale("de", "DE"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;
            case 1:
                Main.setLocale(new Locale("en", "US"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;
                case 2:
                Main.setLocale(new Locale("fr", "FR"));
                ResourceBundle.getBundle("Sprachen", Main.getLocale());
                break;


        }
        updateUI();
    }

    public void switchScene() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("Kontouebersicht.fxml"));
        Scene test = new Scene(fxmlLoader1.load());
        HelloApplication.setScene2(test);
        HelloApplication.switchScene();
    }

    private void updateUI()
    {
        ResourceBundle resources = ResourceBundle.getBundle("Sprachen", Main.getLocale());
        blogin.setText(resources.getString("blogin"));
        lwelcome.setText(resources.getString("lwelcome"));
        lUser.setText(resources.getString("lUser"));
        lPassword.setText(resources.getString("lPassword"));

    }
}