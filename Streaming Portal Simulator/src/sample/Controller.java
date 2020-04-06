package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;


/**
 * Kontroler glownego okna aplikacji
 */

public class Controller implements Initializable{

    public Controller() { }
    //primaryStage
    @FXML
    private MenuItem dodajDystrybutor;
    @FXML
    private MenuItem dodajKlient = new Menu();
    @FXML
    private MenuItem dodajFilm = new MenuItem();
    @FXML
    private MenuItem dodajSerial = new MenuItem();
    @FXML
    private MenuItem dodajLiveStreaming = new Menu();
    @FXML
    private MenuItem zapiszSymulacje = new MenuItem();
    @FXML
    private MenuItem wczytajSymulacje = new MenuItem();
    @FXML
    private Button przyciskOdswiez = new Button();
    @FXML
    private Button przyciskOdswiez2 = new Button();
    @FXML
    private Button przyciskWyswietl =  new Button();
    @FXML
    private ListView<String> listaDziel = new ListView<String>();
    @FXML
    private Button przyciskStart = new Button();
    @FXML
    private Button przyciskStop = new Button();
    @FXML
    private Button przyciskWykres = new Button();
    @FXML
    private TextField poleSzukaj = new TextField();
    @FXML
    private Button przyciskSzukaj = new Button();
    @FXML
    private ComboBox<String> comboBox = new ComboBox<String>();
    @FXML
    private ListView<String> listaKlientow = new ListView<String>();
    @FXML
    private ListView<String> listaDystrybutorow = new ListView<String>();
    @FXML
    private Button przyciskWyswietlKlienta = new Button();
    @FXML
    private Button przyciskWyswietlDystrybutora = new Button();
    @FXML
    private Button przyciskUsunDzielo = new Button();
    @FXML
    private Button przyciskUsunKlienta = new Button();
    @FXML
    private Button przyciskUsunDystrybutora = new Button();
    @FXML
    private Button przyciskAbonamenty = new Button();
    @FXML
    private Text textData = new Text();
    private ObservableList<String> observableListDziela = FXCollections.observableArrayList();
    private ObservableList<String> observableListKlienci = FXCollections.observableArrayList();
    private ObservableList<String> observableListDystrybutorzy = FXCollections.observableArrayList();

    public void onActionWczytaj() throws IOException, ClassNotFoundException {
        Aplikacja.wczytaj_symulacje();
    }

    public void onActionZapisz() throws IOException {
        Aplikacja.zapisz_symulacje();
    }

    public void onActionAbonamenty() throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(this.getClass().getResource("abonamenty.fxml"));
        Parent root = (Parent) loader2.load();
        ControllerAbonamenty controllerAbonamenty = loader2.getController();
        Stage stage2 = new Stage();
        stage2.setTitle("Ceny abonamentow");
        stage2.setScene(new Scene(root));
        stage2.show();
    }

    public void onActionUsunDzielo(){
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaDziel.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_dzielo(nazwa);
            Aplikacja.system.usun_dzielo(indeks);
            onActionOdswiezListe();
        }
    }

    public void onActionUsunDystrybutora(){
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaDystrybutorow.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_dystrybutora(nazwa);
            Aplikacja.system.usun_dystrybutora(indeks);
            onActionOdswiezListe();
        }
    }

    public void onActionUsunKlienta(){
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaKlientow.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_klienta(nazwa);
            Aplikacja.system.usun_klienta(indeks);
            onActionOdswiezListe();
        }
    }

    public void onActionSzukaj(){

        observableListDziela.clear();
        if(Objects.equals(comboBox.getValue(),"Nazwa")) {
            int numer_dziela = Aplikacja.system.znajdz_dzielo(poleSzukaj.getText());
            if (numer_dziela != -1) {
                observableListDziela.add(Aplikacja.system.getDziela_w_bazie().get(numer_dziela).getNazwa());
            }
            listaDziel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            listaDziel.setItems(observableListDziela);
            listaDziel.refresh();
        }
        else {
            for(int i=0; i < Aplikacja.system.getDziela_w_bazie().size(); i++){
                if(Aplikacja.system.getDziela_w_bazie().get(i).czy_wystepuje(poleSzukaj.getText())){
                    observableListDziela.add(Aplikacja.system.getDziela_w_bazie().get(i).getNazwa());
                }
            }
            listaDziel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            listaDziel.setItems(observableListDziela);
            listaDziel.refresh();
        }
    }
    public void onActionWykres() throws IOException {
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(this.getClass().getResource("wykres.fxml"));
        Parent root = (Parent) loader2.load();
        ControllerWykresu controllerWykresu = loader2.getController();
        //loader2.setController(controller2);
        Stage stage2 = new Stage();
        stage2.setTitle("Stan konta");
        stage2.setScene(new Scene(root));
        stage2.show();
    }

    public void onActionStart(){
        Aplikacja.start_symulacji();
    }

    public void onActionStop(){
        Aplikacja.przerwij_symulacje();
    }

    public void onActionOdswiezListe (){

        observableListDziela.clear();
        for (int i=0; i < Aplikacja.system.getDziela_w_bazie().size(); i++){
            observableListDziela.add(Aplikacja.system.getDziela_w_bazie().get(i).getNazwa());
        }
        listaDziel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listaDziel.setItems(observableListDziela);
        listaDziel.refresh();
        System.out.println("odswiezam");

        observableListKlienci.clear();
        for(int i=0; i < Aplikacja.system.getKlienci().size(); i++){
            observableListKlienci.add(Aplikacja.system.getKlienci().get(i).getNazwa());
        }
        listaKlientow.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listaKlientow.setItems(observableListKlienci);
        listaDziel.refresh();

        observableListDystrybutorzy.clear();
        for (int i=0; i < Aplikacja.system.getDystrybutorzy().size(); i++){
            observableListDystrybutorzy.add(Aplikacja.system.getDystrybutorzy().get(i).getNazwa());
        }
        listaKlientow.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listaDystrybutorow.setItems(observableListDystrybutorzy);
        listaKlientow.refresh();

        textData.setText("Data: " + Aplikacja.czas.getData());
    }


    @FXML
    public void onActionWyswietlKlienta() throws IOException {
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaKlientow.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_klienta(nazwa);
            System.out.println(nazwa + " " + String.valueOf(indeks));
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(this.getClass().getResource("wyswietlanieKlientaDystrybutora.fxml"));
            Parent root = (Parent) loader2.load();
            ControllerWyswietlaniaDiK controllerWyswietlaniaDiK = loader2.getController();
            controllerWyswietlaniaDiK.initializeData(true, nazwa, indeks);
            Stage stage2 = new Stage();
            stage2.setTitle(nazwa);
            stage2.setScene(new Scene(root));
            stage2.show();
        }
    }

    @FXML
    public void onActionWyswietlDystrybutora() throws IOException {
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaDystrybutorow.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_dystrybutora(nazwa);
            System.out.println(nazwa + " " + String.valueOf(indeks));
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(this.getClass().getResource("wyswietlanieKlientaDystrybutora.fxml"));
            Parent root = (Parent) loader2.load();
            ControllerWyswietlaniaDiK controllerWyswietlaniaDiK = loader2.getController();
            controllerWyswietlaniaDiK.initializeData(false, nazwa, indeks);
            Stage stage2 = new Stage();
            stage2.setTitle(nazwa);
            stage2.setScene(new Scene(root));
            stage2.show();
        }
    }

    @FXML
    public void onActionWyswietlDzielo() throws IOException {
        if (listaDziel.getSelectionModel().getSelectedItem() != null) {
            String nazwa = listaDziel.getSelectionModel().getSelectedItem();
            int indeks = Aplikacja.system.znajdz_dzielo(nazwa);
            System.out.println(nazwa + " " + String.valueOf(indeks));
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(this.getClass().getResource("wyswietlanie.fxml"));
            Parent root = (Parent) loader2.load();
            ControllerWyswietlaniaDziela controllerWyswietlaniaDziela = loader2.getController();
            controllerWyswietlaniaDziela.initializeData(nazwa, indeks);
            Stage stage2 = new Stage();
            stage2.setTitle(nazwa);
            stage2.setScene(new Scene(root));
            stage2.show();
        }
    }

    @FXML
    public void onActionDodajDystrybutor() throws FileNotFoundException {
        System.out.println("Dodaje dystrybutora");
        try {
            Aplikacja.dodaj_dystrybutora();
            onActionOdswiezListe();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            }
    }



    public void onActionDodajKlient () throws FileNotFoundException {
        System.out.println("Dodaje klienta");
        try {
            Aplikacja.dodaj_klienta();
            onActionOdswiezListe();
        } catch (FileNotFoundException e){
            e.printStackTrace();
            }
    }

    public void onActionDodajSerial () throws FileNotFoundException {
        System.out.println("Dodaje serial");
        try {
            Aplikacja.dodaj_serial();
            onActionOdswiezListe();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e1){

        }
    }

    public void onActionDodajFilm () throws FileNotFoundException{
        System.out.println("Dodaje film");
       try {
           Aplikacja.dodaj_film();
           onActionOdswiezListe();
       } catch (FileNotFoundException e){
           e.printStackTrace();
       }
       catch (IOException e1){

       }
    }

    public void onActionDodajLiveStreaming() throws FileNotFoundException {
        System.out.println("Dodaje live streaming");
        try{
            Aplikacja.dodaj_liveStreaming();
            onActionOdswiezListe();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e1){

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll("Nazwa", "Aktor/Aktorka");
        textData.setText("");
    }
}
