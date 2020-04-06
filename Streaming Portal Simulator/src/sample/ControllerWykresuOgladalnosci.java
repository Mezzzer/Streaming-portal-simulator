package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.lang.reflect.AccessibleObject;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
/**
 * Kontroler okna z wykresem ogladalnosci danego dziela w czasie
 */
public class ControllerWykresuOgladalnosci implements Initializable{
    public ControllerWykresuOgladalnosci() {}
    @FXML
    public LineChart<String, Integer> wykres;

    private int numer_dziela;

    public int getNumer_dziela() {
        return numer_dziela;
    }


    public void initializeData(int numer_dziela) {
        this.numer_dziela = numer_dziela;
        int k = Aplikacja.system.getDziela_w_bazie().get(numer_dziela).getData_premiery();
        XYChart.Series<String, Integer> seria = new XYChart.Series<String, Integer>();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        for (int i = 0; i < Aplikacja.system.getDziela_w_bazie().get(numer_dziela).getWyswietlenia().size(); i++){
        seria.getData().add(new XYChart.Data(Aplikacja.czas.getDaty().get(k++).format(formater), Aplikacja.system.getDziela_w_bazie().get(numer_dziela).getWyswietlenia().get(i)));
        }
        wykres.getData().add(seria);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
