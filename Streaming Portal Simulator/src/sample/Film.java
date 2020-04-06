package sample;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Klasa implementujaca film
 */

public class Film extends Dzielo implements Serializable{
    private String gatunek; //do przerobienia na enum
    private List<String> lista_aktorow;
    private String linki_do_zwiastunow;
    private double czas_do_obejrzenia;
    private Promocja promocja;
    private double cena_po_promocji;

    public Film(String nazwa, String zdjecie, String opis, int rok_produkcji, int czas_trwania, Dystrybutor dystrybutor, String kraj_produkcji, double ocena, String gatunek, List<String> lista_aktorow, String linki_do_zwiastunow, double cena, double czas_do_obejrzenia) {
        super(nazwa, zdjecie, opis, rok_produkcji, czas_trwania, dystrybutor, kraj_produkcji, ocena, cena);
        this.gatunek = gatunek;
        this.lista_aktorow = lista_aktorow;
        this.linki_do_zwiastunow = linki_do_zwiastunow;
        this.czas_do_obejrzenia = czas_do_obejrzenia;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public List<String> getLista_aktorow() {
        return lista_aktorow;
    }

    public void setLista_aktorow(List<String> lista_aktorow) {
        this.lista_aktorow = lista_aktorow;
    }

    public String getLinki_do_zwiastunow() {
        return linki_do_zwiastunow;
    }

    public void setLinki_do_zwiastunow(String linki_do_zwiastunow) {
        this.linki_do_zwiastunow = linki_do_zwiastunow;
    }

    public double getCzas_do_obejrzenia() {
        return czas_do_obejrzenia;
    }

    public void setCzas_do_obejrzenia(double czas_do_obejrzenia) {
        this.czas_do_obejrzenia = czas_do_obejrzenia;
    }

    public Promocja getPromocja() {
        return promocja;
    }

    public void setPromocja(Promocja promocja) {
        this.promocja = promocja;
    }

    public double getCena_po_promocji() {
        return cena_po_promocji;
    }

    public void setCena_po_promocji(double cena_po_promocji) {
        this.cena_po_promocji = cena_po_promocji;
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
        return super.toString() +
                "Gatunek: " + gatunek + "\n" +
                "Lista aktorow: " + this.wyswietl_aktorow() + "\n" +
                "Link do zwiastunu: " + linki_do_zwiastunow + "\n" +
                "Czas do obejrzenia: " + czas_do_obejrzenia;
    }

    public void wyswietl(){
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

    public void przecen(){
        double tmp = this.getCena();
        this.setCena(promocja.getUpust()*this.getCena());
        this.cena_po_promocji = tmp;
    }

    public void stara_cena(){
        this.setCena_po_promocji(this.cena_po_promocji);
    }
}
