package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Klasa implementujaca dystrybutora
 */

public class Dystrybutor implements Runnable, Serializable{
    private String nazwa;
    private List<Dzielo> dziela;
    private double kwota_do_zaplaty;
    private Long nr_konta;

    public List<Dzielo> getDziela() {
        return dziela;
    }

    public Dystrybutor(String nazwa, Long nr_konta) {
        this.nazwa = nazwa;
        this.nr_konta = nr_konta;
        dziela = new ArrayList<Dzielo>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getKwota_do_zaplaty() {
        return kwota_do_zaplaty;
    }

    public void setKwota_do_zaplaty(double kwota_do_zaplaty) {
        this.kwota_do_zaplaty = kwota_do_zaplaty;
    }

    public long getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(Long nr_konta) {
        this.nr_konta = nr_konta;
    }

    //kategorie:
    //1 - serial, 2 - film, 3 - live stream
    public void nowy_produkt(int kategoria) throws FileNotFoundException {
        if (kategoria == 1){
            int w_bazie = 9;
            String nazwa;
            String zdjecie;
            String opis;
            int rok;
            int czas;
            String kraj;
            double ocena;
            String gatunek;
            double cena;
            int sezony;
            int odcinki;
            List<String> aktorzy = new ArrayList<String>();

            Random generator = new Random();
            Generator generator_slow = new Generator();
            nazwa = generator_slow.generuj_nazwe(generator.nextInt(4)+1);
            zdjecie = "Seriale/" + String.valueOf(generator.nextInt(9)) + ".jpeg";
            opis = generator_slow.generuj_nazwe(generator.nextInt(10) + 10);
            rok = generator.nextInt(49) + 1970;
            czas = generator.nextInt(180) + 120;
            kraj = generator_slow.generuj_kraj();
            ocena = generator.nextDouble() + generator.nextInt(9);
            gatunek = String.valueOf(Gatunek.losuj_gatunek());
            for(int i=0; i<3; i++){
                aktorzy.add(generator_slow.generuj_aktora());
            }
            cena = generator.nextDouble() + generator.nextInt(100) + 1;
            cena = BigDecimal.valueOf(cena).setScale(2, RoundingMode.HALF_UP).doubleValue();

            ocena = BigDecimal.valueOf(ocena).setScale(1, RoundingMode.HALF_UP).doubleValue();
            sezony = generator.nextInt(9) + 1;
            odcinki = generator.nextInt(20) + 10;
            List<Odcinek> lista_odcinkow = new ArrayList<Odcinek>();
            List<Sezon> lista_sezonow = new ArrayList<Sezon>();
            for (int i=0; i<sezony; i++){
                for (int j=0; j<(odcinki/sezony); j++){
                    Odcinek nowy_odcinek = new Odcinek(czas, Aplikacja.czas.getData());
                    lista_odcinkow.add(nowy_odcinek);
                }
                Sezon nowy_sezon = new Sezon(odcinki/sezony, lista_odcinkow);
                lista_sezonow.add(nowy_sezon);
            }
            Serial nowy_serial = new Serial(nazwa, zdjecie, opis, rok, czas, this, kraj, ocena, gatunek, cena, sezony, aktorzy, lista_sezonow);
            this.getDziela().add(nowy_serial);
            Aplikacja.system.dodaj_dzielo(nowy_serial);
        }
        else if(kategoria == 2){
            int w_bazie = 9;
            String nazwa;
            String zdjecie;
            String opis;
            int rok;
            int czas;
            String kraj;
            String gatunek;
            double ocena;
            List<String> aktorzy = new ArrayList<String>();
            String zwiastun;
            double cena;
            Random generator = new Random();
            Generator generator_slow = new Generator();
            nazwa = generator_slow.generuj_nazwe(generator.nextInt(4)+1);
            zdjecie = "Filmy/" + String.valueOf(generator.nextInt(9)) + ".jpeg";
            opis = generator_slow.generuj_nazwe(generator.nextInt(10) + 10);
            rok = generator.nextInt(49) + 1970;
            czas = generator.nextInt(180) + 120;
            kraj = generator_slow.generuj_kraj();
            ocena = generator.nextDouble() + generator.nextInt(9);
            ocena = BigDecimal.valueOf(ocena).setScale(1, RoundingMode.HALF_UP).doubleValue();
            gatunek = String.valueOf(Gatunek.losuj_gatunek());
            for(int i=0; i<3; i++){
                aktorzy.add(generator_slow.generuj_aktora());
            }
            zwiastun = "https://www.youtube.com/watch?v=IaH2C2Qe97Y";
            cena = generator.nextDouble() + generator.nextInt(100) + 1;
            cena = BigDecimal.valueOf(cena).setScale(2, RoundingMode.HALF_UP).doubleValue();

            ocena = BigDecimal.valueOf(cena).setScale(1, RoundingMode.HALF_UP).doubleValue();

            Film nowy_film = new Film(nazwa, zdjecie, opis, rok, czas, this, kraj, ocena, gatunek, aktorzy, zwiastun, cena, 24 );
            this.getDziela().add(nowy_film);
            Aplikacja.system.dodaj_dzielo(nowy_film);
        }
        else if (kategoria == 3) {
            String nazwa;
            String opis;
            int rok;
            int czas;
            String kraj;
            double ocena;
            Date data;
            double cena;
            String zdjecie;
            Random generator = new Random();
            Generator generator_slow = new Generator();
            nazwa = generator_slow.generuj_nazwe(generator.nextInt(4)+1);
            zdjecie = "LiveStreaming/1.jpeg";
            opis = generator_slow.generuj_nazwe(generator.nextInt(10) + 10);
            rok = generator.nextInt(49) + 1970;
            czas = generator.nextInt(180) + 120;
            kraj = generator_slow.generuj_kraj();
            ocena = generator.nextDouble() + generator.nextInt(9);
            ocena = BigDecimal.valueOf(ocena).setScale(1, RoundingMode.HALF_UP).doubleValue();
            data = generator_slow.generuj_date();
            cena = generator.nextDouble() + generator.nextInt(100) + 1;
            cena = BigDecimal.valueOf(cena).setScale(2, RoundingMode.HALF_UP).doubleValue();

            Live_Streaming nowy_live = new Live_Streaming(nazwa, zdjecie, opis, rok, czas, this, kraj, ocena, data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), cena);
            this.getDziela().add(nowy_live);
            Aplikacja.system.dodaj_dzielo(nowy_live);
        }
    }

    public void wyswietl_dziela(){
        for(int i=0; i<this.getDziela().size(); i++){
            this.getDziela().get(i).wyswietl();
        }
    }
    public void negocjuj(){
        Random generator = new Random();
        this.setKwota_do_zaplaty(generator.nextInt(1000) + 500);
    }

    public void pobierz_kwote(){
        Aplikacja.wlasciciel.zmien_stan(-kwota_do_zaplaty);
    }

    @Override
    public void run() {
        Random generator = new Random();
        int czy;
        int co_dodac;
        boolean czy_nie_zaplacone = true;
        while (Aplikacja.czy_przerwac){

            if((Aplikacja.czas.getData().getDayOfMonth() == 1) && czy_nie_zaplacone){
                System.out.println(this.getNazwa() + "Place");
                this.pobierz_kwote();
                czy_nie_zaplacone = false;
            }

            if(Aplikacja.czas.getData().getDayOfMonth()== 2){
                czy_nie_zaplacone = true;
            }

            czy = generator.nextInt(500000000);
            if(czy == 1){
                System.out.println(czy);
                co_dodac = generator.nextInt(2) + 1;
                if(co_dodac == 1){
                    try {
                        this.nowy_produkt(1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                else if (co_dodac == 2){
                    try {
                        this.nowy_produkt(2);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                else
                    try {
                        this.nowy_produkt(3);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
            }

            czy = generator.nextInt(500000000);
            if(czy == 0){
                this.negocjuj();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getNazwa() + " przerwany");
    }

    @Override
    public String toString() {
        return "DYSTRYBUTOR" + "\n" +
                "Nazwa: " + nazwa + "\n" +
                "Kwota do zaplaty: " + kwota_do_zaplaty + "\n" +
                "Nr konta: " + nr_konta;
    }
}
