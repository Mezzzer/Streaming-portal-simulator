package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler okna z mozliwoscia zmiany cen abonamentow
 */
public class ControllerAbonamenty implements Initializable {
    @FXML
    private TextField textFieldBasic = new TextField();
    @FXML
    private TextField textFieldFamily = new TextField();
    @FXML
    private TextField textFieldPro = new TextField();
    @FXML
    private Button przyciskBasic = new Button();
    @FXML
    private Button przyciskFamily = new Button();
    @FXML
    private Button przyciskPro = new Button();
    @FXML
    private Text textBasic = new Text();
    @FXML
    private Text textFamily = new Text();
    @FXML
    private Text textPro = new Text();


    public void onActionBasic(){
        Aplikacja.system.dostepne_abonamenty.get(1).setCena(Double.parseDouble(textFieldBasic.getText()));
        textBasic.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(1).getCena()));
    }

    public void onActionFamily(){
        Aplikacja.system.dostepne_abonamenty.get(2).setCena(Double.parseDouble(textFieldFamily.getText()));
        textFamily.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(2).getCena()));
    }

    public void onActionPro(){
        Aplikacja.system.dostepne_abonamenty.get(3).setCena(Double.parseDouble(textFieldPro.getText()));
        textPro.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(3).getCena()));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textBasic.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(1).getCena()));
        textFamily.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(2).getCena()));
        textPro.setText("Cena: " + Double.toString(Aplikacja.system.dostepne_abonamenty.get(3).getCena()));
    }
}
