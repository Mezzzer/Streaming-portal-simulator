package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa implementujaca dzielo
 */

public class Dzielo implements Serializable{
    private String nazwa;
    private String zdjecie;
    private String opis;
    private int rok_produkcji;
    private int czas_trwania;
    private Dystrybutor dystrybutor;
    private String kraj_produkcji;
    private double cena;
    private double ocena;
    private Integer wyswietlenie;
    private List<Integer> wyswietlenia;
    //przechowuje numer daty w tablicy dat w aplikacji - czas
    private int data_premiery;


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getRok() {
        return rok_produkcji;
    }

    public void setRok(int rok) {
        this.rok_produkcji = rok;
    }

    public int getCzas_trwania() {
        return czas_trwania;
    }

    public void setCzas_trwania(int czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    public Dystrybutor getDystrybutor() {
        return dystrybutor;
    }

    public void setDystrybutor(Dystrybutor dystrybutor) {
        this.dystrybutor = dystrybutor;
    }

    public String getKraj_produkcji() {
        return kraj_produkcji;
    }

    public void setKraj_produkcji(String kraj_produkcji) {
        this.kraj_produkcji = kraj_produkcji;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Integer getWyswietlenie() {
        return wyswietlenie;
    }

    public void setWyswietlenie(Integer wyswietlenie) {
        this.wyswietlenie = wyswietlenie;
    }

    public List<Integer> getWyswietlenia() {
        return wyswietlenia;
    }

    public void setWyswietlenia(List<Integer> wyswietlenia) {
        this.wyswietlenia = wyswietlenia;
    }

    public int getData_premiery() {
        return data_premiery;
    }

    public void setData_premiery(int data_premiery) {
        this.data_premiery = data_premiery;
    }

    public Dzielo(String nazwa, String zdjecie, String opis, int rok_produkcji, int czas_trwania, Dystrybutor dystrybutor, String kraj_produkcji, double ocena, double cena) {
        this.nazwa = nazwa;
        this.zdjecie = zdjecie;
        this.opis = opis;
        this.rok_produkcji = rok_produkcji;
        this.czas_trwania = czas_trwania;
        this.dystrybutor = dystrybutor;
        this.kraj_produkcji = kraj_produkcji;
        this.ocena = ocena;
        this.cena = cena;
        this.wyswietlenia = new ArrayList<Integer>();
        this.data_premiery = Aplikacja.czas.getDaty().size();
        wyswietlenie = 0;
    }


    @Override
    public String toString() {
        return "Nazwa: " + nazwa + "\n" +
                "Opis: " + opis + "\n" +
                "Rok_produkcji: " + rok_produkcji + "\n" +
                "Czas_trwania: " + czas_trwania + "\n" +
                "Dystrybutor: " + dystrybutor.getNazwa() + "\n" +
                "Kraj_produkcji: " + kraj_produkcji + "\n" +
                "Ocena: " + ocena + "\n";
    }

    public void wyswietl(){
        System.out.println(this.toString());
    }

    public void zwieksz_wyswietlenie(){
        this.wyswietlenie += 1;
    }

    public void dodaj_wyswietlenie(){
        this.wyswietlenia.add(wyswietlenie);
        //System.out.println(this.getNazwa() + "wyswietlenie: " + Integer.toString(this.wyswietlenie));
        this.wyswietlenie = 0;
    }

    public boolean czy_wystepuje(String aktor){
        return false;
    }

    public void przecen(){}
    public void stara_cena(){}
}
