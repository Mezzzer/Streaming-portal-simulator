package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa implementujaca wlasciciela systemu VOD
 */

public class Wlasciciel implements Serializable{
    private double stan_konta;
    private List<Double> zmiany_stanu;
    private List<LocalDate> daty_zmiany;

    //ustawienie stanu poczatkowego konta wlasciciela
    public Wlasciciel(double stan_konta) {
        this.stan_konta = stan_konta;
        this.zmiany_stanu = new ArrayList<Double>();
        this.daty_zmiany = new ArrayList<LocalDate>();
    }

    public double getStan_konta() {
        return stan_konta;
    }

    public void setStan_konta(double stan_konta) {
        this.stan_konta = stan_konta;
    }

    public void zmien_stan(double x){
        this.stan_konta += x;
    }

    public List<Double> getZmiany_stanu() {
        return zmiany_stanu;
    }

    public void setZmiany_stanu(List<Double> zmiany_stanu) {
        this.zmiany_stanu = zmiany_stanu;
    }

    public List<LocalDate> getDaty_zmiany() {
        return daty_zmiany;
    }

    public void setDaty_zmiany(List<LocalDate> daty_zmiany) {
        this.daty_zmiany = daty_zmiany;
    }

    public void dodaj_zmiane_stanu(){
        this.zmiany_stanu.add(this.stan_konta);
        this.daty_zmiany.add(Aplikacja.czas.getData());
    }
}
