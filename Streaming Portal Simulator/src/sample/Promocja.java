package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasa implementujaca promocje.
 */

public class Promocja implements Serializable{
    LocalDate data_rozpoczecia;
    LocalDate data_zakonczenia;
    private double upust;
    private List<Dzielo> przecenione_dziela;

    public Promocja(LocalDate data_rozpoczecia, LocalDate data_zakonczenia, double upust) {
        this.data_rozpoczecia = data_rozpoczecia;
        this.data_zakonczenia = data_zakonczenia;
        this.upust = upust;
        przecenione_dziela = new ArrayList<Dzielo>();
    }

    public double getUpust() {
        return upust;
    }

    public void setUpust(double upust) {
        this.upust = upust;
    }

    public LocalDate getData_rozpoczecia() {
        return data_rozpoczecia;
    }

    public void setData_rozpoczecia(LocalDate data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public LocalDate getData_zakonczenia() {
        return data_zakonczenia;
    }

    public void setData_zakonczenia(LocalDate data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }

    public List<Dzielo> getPrzecenione_dziela() {
        return przecenione_dziela;
    }

    public void setPrzecenione_dziela(List<Dzielo> przecenione_dziela) {
        this.przecenione_dziela = przecenione_dziela;
    }

    public void przecen_dziela(int ile){
        Random generator = new Random();
        int ktore = generator.nextInt(Aplikacja.system.getDziela_w_bazie().size());
        for (int i=0; i < Aplikacja.system.getDziela_w_bazie().size(); i++){
            if(Aplikacja.system.getDziela_w_bazie().get(ktore) instanceof Film || Aplikacja.system.getDziela_w_bazie().get(ktore) instanceof Live_Streaming){
                przecenione_dziela.add(Aplikacja.system.getDziela_w_bazie().get(ktore));
                ((Live_Streaming) Aplikacja.system.getDziela_w_bazie().get(ktore)).setPromocja(this);
            }
        }
        for(int i = 0; i < this.przecenione_dziela.size(); i++)
            przecenione_dziela.get(i).przecen();
    }

    public void zakoncz(){
        for (int i = 0; i < this.przecenione_dziela.size(); i++)
            przecenione_dziela.get(i).stara_cena();
    }
}
