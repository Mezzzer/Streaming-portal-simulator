package sample;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Klasa implementujaca serial
 */

public class Serial extends Dzielo implements Serializable{
    private String gatunek; //trzeba zmienic na enum jak w filamch
    private int liczba_sezonow;
    private List<String> lista_aktorow;
    private List<Sezon> lista_sezonow;

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getLiczba_sezonow() {
        return liczba_sezonow;
    }

    public void setLiczba_sezonow(int liczba_sezonow) {
        this.liczba_sezonow = liczba_sezonow;
    }

    public List<String> getLista_aktorow() {
        return lista_aktorow;
    }

    public void setLista_aktorow(List<String> lista_aktorow) {
        this.lista_aktorow = lista_aktorow;
    }

    public List<Sezon> getLista_sezonow() {
        return lista_sezonow;
    }

    public void setLista_sezonow(List<Sezon> lista_sezonow) {
        this.lista_sezonow = lista_sezonow;
    }

    public Serial(String nazwa, String zdjecie, String opis, int rok_produkcji, int czas_trwania, Dystrybutor dystrybutor, String kraj_produkcji, double ocena, String gatunek, double cena, int liczba_sezonow, List<String> lista_aktorow, List<Sezon> lista_sezonow) {
        super(nazwa, zdjecie, opis, rok_produkcji, czas_trwania, dystrybutor, kraj_produkcji, ocena, cena);
        this.gatunek = gatunek;
        this.liczba_sezonow = liczba_sezonow;
        this.lista_aktorow = lista_aktorow;
        this.lista_sezonow = lista_sezonow;
    }

    public String wyswietl_aktorow(){
        String aktorzy = "";
        for(int i=0; i<this.lista_aktorow.size()-1; i++) {
            aktorzy = aktorzy + this.lista_aktorow.get(i) + ", ";
        }
        aktorzy = aktorzy + this.lista_aktorow.get(lista_aktorow.size()-1);
        return aktorzy;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Gatunek: " + gatunek + "\n" +
                "Liczba sezonow: " + liczba_sezonow + "\n" +
                "Lista aktorow: " + this.wyswietl_aktorow();
    }

    public void wyswietl() {
        System.out.println(this.toString());
    }

    public boolean czy_wystepuje(String aktor){
        for(int i=0; i < this.lista_aktorow.size(); i++){
            if(Objects.equals(this.lista_aktorow.get(i),aktor)){
                return true;
            }
        }
        return false;
    }
}
