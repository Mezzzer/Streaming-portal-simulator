package sample;

import java.io.Serializable;
/**
 * Przechowuje dane na temat abonamentow
 */

public class Abonament implements Serializable{
    private String rodzaj;
    private double cena;
    private int liczba_urzadzen;
    private Rozdzielczosc rozdzielczosc;

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getLiczba_urzadzen() {
        return liczba_urzadzen;
    }

    public void setLiczba_urzadzen(int liczba_urzadzen) {
        this.liczba_urzadzen = liczba_urzadzen;
    }

    public Rozdzielczosc getRozdzielczosc() {
        return rozdzielczosc;
    }

    public void setRozdzielczosc(Rozdzielczosc rozdzielczosc) {
        this.rozdzielczosc = rozdzielczosc;
    }

    public Abonament(String rodzaj, double cena, int liczba_urzadzen, int x, int y) {
        this.rodzaj = rodzaj;
        this.cena = cena;
        this.liczba_urzadzen = liczba_urzadzen;
        this.rozdzielczosc = new Rozdzielczosc(x,y);
    }
}
