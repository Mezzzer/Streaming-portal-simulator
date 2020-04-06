package sample;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 * Klasa przechowujaca czas symulacji.
 * Jej watek co ok. 3000 milisekund dodaje jeden dzien do aktualnej daty w systemie. Odpowiada takze za funkcje, ktore zaleza od czasu symulacji.
 */
public class Czas implements Runnable, Serializable{

    private long przedzial_1;
    private long przedzial_2;
    private LocalDate data;
    private List<LocalDate> daty;


    public long getPrzedzial_1() {
        return przedzial_1;
    }

    public void setPrzedzial_1(long przedzial_1) {
        this.przedzial_1 = przedzial_1;
    }

    public long getPrzedzial_2() {
        return przedzial_2;
    }

    public void setPrzedzial_2(long przedzial_2) {
        this.przedzial_2 = przedzial_2;
    }



    public Czas(LocalDate data) {
        this.przedzial_1 = System.currentTimeMillis();
        this.przedzial_2 = System.currentTimeMillis() + 3000;
        this.data = data;
        this.daty = new ArrayList<LocalDate>();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<LocalDate> getDaty() {
        return daty;
    }

    public void setDaty(List<LocalDate> daty) {
        this.daty = daty;
    }

    @Override
    public void run() {
        Random generator = new Random();
       Promocja promocja = new Promocja(this.data, this.data.plusDays(generator.nextInt(7)), generator.nextDouble());;
        if(Aplikacja.dziela_w_bazie.size() != 0){
            promocja.przecen_dziela(generator.nextInt(Aplikacja.dziela_w_bazie.size()));
        }

        while (Aplikacja.czy_przerwac) {
            this.setPrzedzial_1(System.currentTimeMillis());
            if (this.getPrzedzial_1() >= this.getPrzedzial_2()) {
                this.setPrzedzial_2(System.currentTimeMillis() + 3000);
                this.daty.add(this.data);
                this.setData(this.getData().plusDays(1));
                System.out.println(this.getData().toString());
                System.out.println(Aplikacja.wlasciciel.getStan_konta());
                Aplikacja.wlasciciel.dodaj_zmiane_stanu();
                for (int i=0; i < Aplikacja.system.getDziela_w_bazie().size(); i++)
                    Aplikacja.system.getDziela_w_bazie().get(i).dodaj_wyswietlenie();
                if(generator.nextInt(20000000) == 0){
                    try {
                        Aplikacja.dodaj_klienta();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if(promocja.data_rozpoczecia == this.data){
                    promocja.zakoncz();
                    promocja = null;
                    promocja = new Promocja(this.data, this.data.plusDays(generator.nextInt(7)), generator.nextDouble());
                    promocja.przecen_dziela(generator.nextInt(Aplikacja.dziela_w_bazie.size()));
                }

                if(this.daty.size() != 0){
                    if(Duration.between(this.daty.get(0).atStartOfDay(),this.data.atStartOfDay()).toDays() == 90)
                        if(Aplikacja.wlasciciel.getStan_konta() < 0){
                            Aplikacja.przerwij_symulacje();
                        }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Czas przerwany");
    }
}
