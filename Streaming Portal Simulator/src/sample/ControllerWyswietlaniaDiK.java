package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler okna z informacjami na temat klienta lub dystrybutora
 */
public class ControllerWyswietlaniaDiK implements Initializable{

    public ControllerWyswietlaniaDiK(){}

    @FXML
    private javafx.scene.text.Text text = new javafx.scene.text.Text();

    private boolean czy_klient;
    private String nazwa;
    private int indeks;

    public void initializeData(boolean czy_klient, String nazwa, int indeks){
        this.czy_klient = czy_klient;
        this.nazwa = nazwa;
        this.indeks = indeks;
        if(czy_klient){
            text.setText(Aplikacja.system.getKlienci().get(indeks).toString());
        }
        else
           text.setText(Aplikacja.system.getDystrybutorzy().get(indeks).toString());
        //text.setText(Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).toString());
        text.setFont(new Font("Times New Roman",14));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
