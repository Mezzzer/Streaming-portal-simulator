package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Klasa implementujaca live streaming.
 */

public class Live_Streaming extends Dzielo implements Serializable{
    private LocalDate data;
    private Promocja promocja;
    private double cena_po_promocji;

    public Live_Streaming(String nazwa, String zdjecie, String opis, int rok_produkcji, int czas_trwania, Dystrybutor dystrybutor, String kraj_produkcji, double ocena, LocalDate data, double cena) {
        super(nazwa, zdjecie, opis, rok_produkcji, czas_trwania, dystrybutor, kraj_produkcji, ocena, cena);
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public double getCena_po_promocji() {
        return cena_po_promocji;
    }

    public void setCena_po_promocji(double cena_po_promocji) {
        this.cena_po_promocji = cena_po_promocji;
    }

    public Promocja getPromocja() {
        return promocja;
    }

    public void setPromocja(Promocja promocja) {
        this.promocja = promocja;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Data: " + data + "\n" +
                "Cena po promocji: " + cena_po_promocji;
    }

    public void wyswietl(){
        System.out.println(this.toString());
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
