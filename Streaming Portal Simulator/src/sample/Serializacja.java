package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa wykorzystywana podczas serializacji.
 * Klasa ta powstala, poniewaz zostaly uzyte statyczne metody (zmiana ich skutkowaloby potrzeba calkowitego przerobienia projektu, a na tym etapie pracy byloby to niemozliwe) nie sa serializowane wiec sa kopiowane do tej klasy, ktora nastepnie serializuje.
 */
public class Serializacja implements Serializable {
    Czas czas;
    System_VOD system;
    Wlasciciel wlasciciel;
    public List<Abonament> dostepne_abonamenty;
    public List<Dzielo> dziela_w_bazie;

    public Serializacja(Czas czas, System_VOD system, Wlasciciel wlasciciel, List<Abonament> dostepne_abonamenty, List<Dzielo> dziela_w_bazie) {
        this.czas = czas;
        this.system = system;
        this.wlasciciel = wlasciciel;
        this.dostepne_abonamenty = dostepne_abonamenty;
        this.dziela_w_bazie = dziela_w_bazie;
    }

    public Czas getCzas() {
        return czas;
    }

    public void setCzas(Czas czas) {
        this.czas = czas;
    }

    public System_VOD getSystem() {
        return system;
    }

    public void setSystem(System_VOD system) {
        this.system = system;
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public List<Abonament> getDostepne_abonamenty() {
        return dostepne_abonamenty;
    }

    public void setDostepne_abonamenty(List<Abonament> dostepne_abonamenty) {
        this.dostepne_abonamenty = dostepne_abonamenty;
    }

    public List<Dzielo> getDziela_w_bazie() {
        return dziela_w_bazie;
    }

    public void setDziela_w_bazie(List<Dzielo> dziela_w_bazie) {
        this.dziela_w_bazie = dziela_w_bazie;
    }
}
