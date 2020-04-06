package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Kontroler wyswietlania wykresu stanu konta wlasciciela w czasie
 */

public class ControllerWykresu implements Initializable{
    public ControllerWykresu() {}

    @FXML
    private LineChart<String, Double> wykres;


    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series<String, Double> seria = new XYChart.Series<String, Double>();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        for (int i=0; i < Aplikacja.wlasciciel.getZmiany_stanu().size(); i++){
            seria.getData().add(new XYChart.Data(Aplikacja.wlasciciel.getDaty_zmiany().get(i).format(formater),Aplikacja.wlasciciel.getZmiany_stanu().get(i)));
        }
        wykres.getData().add(seria);
    }
}
