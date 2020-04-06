package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasa zawierajaca podstawowe elementy Systemu VOD
 */

public class System_VOD implements Serializable{
    public List<Abonament> dostepne_abonamenty;
    public volatile List<Dzielo> dziela_w_bazie;
    public List<Dystrybutor> dystrybutorzy;
    public List<Klient> klienci;
    public List<Thread> watki_klientow;
    public List<Thread> watki_dystrybutorow;

    public List<Abonament> getDostepne_abonamenty() {
        return dostepne_abonamenty;
    }

    public void setDostepne_abonamenty(List<Abonament> dostepne_abonamenty) {
        this.dostepne_abonamenty = dostepne_abonamenty;
    }

    public List<Dystrybutor> getDystrybutorzy() {
        return dystrybutorzy;
    }

    public void setDystrybutorzy(List<Dystrybutor> dystrybutorzy) {
        this.dystrybutorzy = dystrybutorzy;
    }

    public List<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(List<Klient> klienci) {
        this.klienci = klienci;
    }

    public List<Dzielo> getDziela_w_bazie() {
        return dziela_w_bazie;
    }

    public void setDziela_w_bazie(List<Dzielo> dziela_w_bazie) {
        this.dziela_w_bazie = dziela_w_bazie;
    }

    public List<Thread> getWatki_klientow() {
        return watki_klientow;
    }

    public void setWatki_klientow(List<Thread> watki_klientow) {
        this.watki_klientow = watki_klientow;
    }

    public List<Thread> getWatki_dystrybutorow() {
        return watki_dystrybutorow;
    }

    public void setWatki_dystrybutorow(List<Thread> watki_dystrybutorow) {
        this.watki_dystrybutorow = watki_dystrybutorow;
    }

    public System_VOD() {
        dostepne_abonamenty = new ArrayList<Abonament>();
        dziela_w_bazie = new ArrayList<Dzielo>();
        Abonament brak = new Abonament("Brak", 0, 0, 0, 0);
        dostepne_abonamenty.add(brak);
        Abonament basic = new Abonament("Basic", 30, 1, 640, 480);
        dostepne_abonamenty.add(basic);
        Abonament family = new Abonament("Family", 60, 5, 1280, 720);
        dostepne_abonamenty.add(family);
        Abonament premium = new Abonament("Premium", 80, 6,1920, 1080);
        dostepne_abonamenty.add(premium);

        this.dziela_w_bazie = new ArrayList<Dzielo>();
        this.dystrybutorzy = new ArrayList<Dystrybutor>();
        this.klienci = new ArrayList<Klient>();
        this.watki_dystrybutorow = new ArrayList<Thread>();
        this.watki_klientow = new ArrayList<Thread>();
    }

    public int liczba_dziel(){
        return this.dziela_w_bazie.size();
    }
    public void dodaj_dzielo(Dzielo dzielo){
        this.dziela_w_bazie.add(dzielo);
    }

    public void dodaj_dystrybutora (Dystrybutor dystrybutor) {
        this.dystrybutorzy.add(dystrybutor);
        Thread nowy_watek = new Thread(dystrybutor);
        this.watki_dystrybutorow.add(nowy_watek);
    }

    public void dodaj_klienta (Klient klient) {
        this.klienci.add(klient);
        Thread nowy_watek = new Thread(klient);
        this.watki_klientow.add(nowy_watek);
    }

    public void wyswietl_dziela (){
        System.out.printf("Rozmiar:%d%n", this.getDziela_w_bazie().size());
        for(int i=0; i<this.getDziela_w_bazie().size(); i++)
            this.getDziela_w_bazie().get(i).wyswietl();
    }

    //zwraca indeks dziela lub -1 w przypadku nie znalezienia
    public int znajdz_dzielo(String nazwa){
        for(int i=0; i<this.getDziela_w_bazie().size(); i++){
            if(Objects.equals(nazwa,this.getDziela_w_bazie().get(i).getNazwa())){
                return i;
            }
        }
        return -1;
    }

    public int znajdz_klienta(String nazwa){
        for(int i=0; i<this.getKlienci().size(); i++){
            if(Objects.equals(nazwa,this.getKlienci().get(i).getNazwa())){
                return i;
            }
        }
        return -1;
    }

    public int znajdz_dystrybutora(String nazwa){
        for(int i=0; i<this.getDystrybutorzy().size(); i++){
            if(Objects.equals(nazwa,this.getDystrybutorzy().get(i).getNazwa())){
                return i;
            }
        }
        return -1;
    }

    public void usun_dzielo(int indeks){
        this.dziela_w_bazie.remove(indeks);
    }

    public void usun_dystrybutora(int indeks){
        this.dystrybutorzy.remove(indeks);
    }

    public void usun_klienta(int indeks){
        this.klienci.remove(indeks);
    }
}
