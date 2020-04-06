package sample;

import java.io.Serializable;
import java.util.List;

/**
 * Klasa implementujaca sezon serialu
 */

public class Sezon implements Serializable{
    private int liczba_odcinkow;
    private List<Odcinek> lista_odcinkow;

    public int getLiczba_odcinkow() {
        return liczba_odcinkow;
    }

    public void setLiczba_odcinkow(int liczba_odcinkow) {
        this.liczba_odcinkow = liczba_odcinkow;
    }

    public List<Odcinek> getLista_odcinkow() {
        return lista_odcinkow;
    }

    public void setLista_odcinkow(List<Odcinek> lista_odcinkow) {
        this.lista_odcinkow = lista_odcinkow;
    }

    Sezon(int liczba_odcinkow_tmp, List<Odcinek> lista_odcinkow_tmp){
        liczba_odcinkow = liczba_odcinkow_tmp;
        lista_odcinkow = lista_odcinkow_tmp;
    }
}
