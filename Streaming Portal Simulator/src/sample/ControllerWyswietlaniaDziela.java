package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler wyswietlania dziela (filmu, serialu i live streamingu)
 */

public class ControllerWyswietlaniaDziela implements Initializable{
    //secondaryStage
    @FXML
    private ImageView zdjecie = new ImageView();
    @FXML
    private Text text = new Text();
    @FXML
    private Button przyciskWykres = new Button();
    @FXML
    private Text textCena = new Text();
    @FXML
    private Button przyciskZmien = new Button();
    @FXML
    private TextField textFieldCena = new TextField();

    private String nazwa_dziela;
    private int indeks_dziela;

    public ControllerWyswietlaniaDziela() { }

    public String getNazwa_dziela() {
        return nazwa_dziela;
    }

    public void setNazwa_dziela(String nazwa_dziela) {
        this.nazwa_dziela = nazwa_dziela;
    }

    public int getIndeks_dziela() {
        return indeks_dziela;
    }

    public void setIndeks_dziela(int indeks_dziela) {
        this.indeks_dziela = indeks_dziela;
    }

    public void initializeData(String nazwa_dziela, int indeks_dziela){
        this.indeks_dziela = indeks_dziela;
        this.nazwa_dziela = nazwa_dziela;
        text.setText(Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).toString());
        text.setFont(new Font("Times New Roman",14));
        Image image = new Image("file:" + Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).getZdjecie());
        System.out.println(image.getUrl());
        zdjecie.setImage(image);
        textCena.setText("Cena: " + Double.toString(Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).getCena()));
    }


    public void onActionZmienCene(){
        double nowa_cena = Double.parseDouble(textFieldCena.getText());
        Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).setCena(nowa_cena);
        textCena.setText("Cena: " + Double.toString(Aplikacja.system.getDziela_w_bazie().get(indeks_dziela).getCena()));
    }

    public void onActionWykres() throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(this.getClass().getResource("wykresOgladalnosci.fxml"));
        Parent root = (Parent) loader2.load();
        ControllerWykresuOgladalnosci controllerWykresuOgladalnosci = loader2.getController();
        controllerWykresuOgladalnosci.initializeData(indeks_dziela);
        Stage stage2 = new Stage();
        stage2.setTitle("Ogladalnosc");
        stage2.setScene(new Scene(root));
        stage2.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
