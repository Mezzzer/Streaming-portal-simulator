package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Klasa zawiera podstawowe funkcje aplikacji, z ktorych korzysta uzytkownik.
 * Znajduje sie tu takze funkcja main.
 */

public class Aplikacja extends Application implements Serializable{

    public static List<Abonament> dostepne_abonamenty = new ArrayList<Abonament>();
    public static List<Dzielo> dziela_w_bazie = new ArrayList<Dzielo>();
    public static System_VOD system;
    public static Wlasciciel wlasciciel;
    //przy wartosci true symulacja trwa, przy false przerywa sie
    public static boolean czy_przerwac;
    public static Czas czas;
    public static Thread watek_czasu;

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("sample.fxml"));
        //StackPane stackPane = loader.load();
        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);

        Controller kontroler = loader.getController();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja");
        primaryStage.show();
    }

   public static void dodaj_dystrybutora() throws FileNotFoundException {
       int w_bazie = 4;
       String nazwa;
       Long nr_konta;

       Random generator = new Random();
       Generator generator_slow = new Generator();
       nazwa = generator_slow.generuj_nazwe_dystrybutora(2);
       nr_konta = Long.valueOf(generator.nextInt(99999999) + 1000000000);
       Dystrybutor nowy_dystrybutor = new Dystrybutor(nazwa, nr_konta);
       system.dodaj_dystrybutora(nowy_dystrybutor);
   }

   public static void dodaj_klienta() throws FileNotFoundException {
      int w_bazie = 9;
       String nazwa;
       Date data;
       String email;
       long numer_karty;
       Abonament abonament;
       int numer_abonamentu;
       Random generator = new Random();
       Generator generator_slow = new Generator();
       nazwa = generator_slow.generuj_login(3);
       data = generator_slow.generuj_date();
       numer_abonamentu = generator.nextInt(3);
       email = generator_slow.getEmail();
       numer_karty = generator.nextInt(9999) + 10000;
       Klient nowy_klient = new Klient(nazwa, data, email, numer_karty, system.dostepne_abonamenty.get(numer_abonamentu));
       system.dodaj_klienta(nowy_klient);
       System.out.println(nowy_klient.getAbonament().getRodzaj());
   }


   public static void dodaj_serial() throws IOException {
       Random generator = new Random();
       if(system.getDystrybutorzy().size() != 0) {
           int ktory_dystrybutor = generator.nextInt(system.getDystrybutorzy().size());
           system.getDystrybutorzy().get(ktory_dystrybutor).nowy_produkt(1);
       }
   }

   public static void dodaj_film() throws IOException {
       if (system.getDystrybutorzy().size() != 0){
           Random generator = new Random();
           int ktory_dystrybutor = generator.nextInt(system.getDystrybutorzy().size());
           system.getDystrybutorzy().get(ktory_dystrybutor).nowy_produkt(2);
       }
   }

   public static void dodaj_liveStreaming() throws IOException {
       if (system.getDystrybutorzy().size() != 0) {
           Random generator = new Random();
           int ktory_dystrybutor = generator.nextInt(system.getDystrybutorzy().size());
           system.getDystrybutorzy().get(ktory_dystrybutor).nowy_produkt(3);
       }
   }


   public static void start_symulacji(){
        czy_przerwac = true;
        watek_czasu.start();
        for(int i=0; i < system.getDystrybutorzy().size(); i++)
            system.getWatki_dystrybutorow().get(i).start();
        for(int i=0; i<system.getKlienci().size(); i++)
            system.getWatki_klientow().get(i).start();
   }

   public static void przerwij_symulacje(){
        czy_przerwac = false;
        watek_czasu = null;
       for(int i=0; i < system.getDystrybutorzy().size(); i++) {
           system.getWatki_dystrybutorow().clear();
       }
       for(int i=0; i<system.getKlienci().size(); i++)
           system.getWatki_klientow().clear();
   }


   public static void zapisz_symulacje() throws IOException {
        Serializacja serializacja = new Serializacja(czas, system, wlasciciel,dostepne_abonamenty, dziela_w_bazie);
        String nazwaPliku = "symulacja.ser";
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nazwaPliku)));
        out.writeObject(serializacja);
        out.close();
   }

   public static void wczytaj_symulacje() throws IOException, ClassNotFoundException {
       String nazwaPliku = "symulacja.ser";
       ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nazwaPliku)));
       Serializacja serializacja;
       serializacja = (Serializacja) in.readObject();
       System.out.println("Data po wczytaniu: " + serializacja.getCzas().getData());
       czas = serializacja.getCzas();
       system = serializacja.getSystem();
       wlasciciel = serializacja.getWlasciciel();
       dostepne_abonamenty = serializacja.getDostepne_abonamenty();
       dziela_w_bazie = serializacja.getDziela_w_bazie();
       watek_czasu = new Thread(serializacja.getCzas());
       List<Thread> watki_klientow = new ArrayList<Thread>();
       List<Thread> watki_dystrybutorow = new ArrayList<Thread>();

       for(int i=0; i < system.getKlienci().size(); i++)
           watki_klientow.add(new Thread(system.getKlienci().get(i)));
       for(int i=0; i < system.getDystrybutorzy().size(); i++)
           watki_dystrybutorow.add(new Thread(system.getDystrybutorzy().get(i)));

       system.setWatki_klientow(watki_klientow);
       system.setWatki_dystrybutorow(watki_dystrybutorow);
       in.close();

   }

    public static void main(String[] args) throws IOException, InterruptedException {
        LocalDate poczatkowa_data = LocalDate.now();
        czas = new Czas(poczatkowa_data);
        watek_czasu = new Thread(czas);
        system = new sample.System_VOD();
        wlasciciel = new sample.Wlasciciel(100);
        launch(args);
    }
}