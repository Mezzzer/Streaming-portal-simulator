package sample;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Klasa implementujaca klienta
 */

public class Klient implements Runnable, Serializable{
    private String nazwa;
    private Date data_urodzenia;
    private String email;
    private long nr_karty;
    private Abonament abonament;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNr_karty() {
        return nr_karty;
    }

    public void setNr_karty(long nr_karty) {
        this.nr_karty = nr_karty;
    }

    public Abonament getAbonament() {
        return abonament;
    }

    public void setAbonament(Abonament abonament) {
        this.abonament = abonament;
    }

    public Klient(String nazwa, Date data_urodzenia, String email, long nr_karty, Abonament abonament) {
        this.nazwa = nazwa;
        this.data_urodzenia = data_urodzenia;
        this.email = email;
        this.nr_karty = nr_karty;
        this.abonament = abonament;
    }


    public void zamow(){
        Random generator = new Random();
        int ktore;
        if(Aplikacja.system.liczba_dziel() != 0){
            ktore = generator.nextInt(Aplikacja.system.liczba_dziel());
            this.zaplac(Aplikacja.system.getDziela_w_bazie().get(ktore).getCena());
            Aplikacja.system.getDziela_w_bazie().get(ktore).zwieksz_wyswietlenie();
        }
    }

    public void wyswietl() {
        System.out.println(this.getNazwa());
        System.out.println(this.getEmail());
        System.out.println(this.getData_urodzenia());
        System.out.println(this.getNr_karty());
    }

    public void zaplac(double cena) {
        Aplikacja.wlasciciel.zmien_stan(cena);
    }


    public void obejrzyj(){
        Random generator = new Random();
        int ktore;
        if(Aplikacja.system.liczba_dziel() != 0) {
            ktore = generator.nextInt(Aplikacja.system.liczba_dziel());
            //System.out.println("Ogladam dzielo: " + Aplikacja.system.getDziela_w_bazie().get(ktore).getNazwa());
            if(Aplikacja.system.getDziela_w_bazie().get(ktore) instanceof Live_Streaming) {
                if (((Live_Streaming) Aplikacja.system.getDziela_w_bazie().get(ktore)).getData() == Aplikacja.czas.getData()) {
                    Aplikacja.system.getDziela_w_bazie().get(ktore).zwieksz_wyswietlenie();
                }
            }
            else
                Aplikacja.system.getDziela_w_bazie().get(ktore).zwieksz_wyswietlenie();
        }
    }


    @Override
    public void run() {
        Random generator = new Random();
        int czy;
        boolean czy_nie_zaplacone = true;
        while (Aplikacja.czy_przerwac) {
            if (Objects.equals(this.abonament.getRodzaj(),"Brak")) {
                czy = generator.nextInt(20000000);
                if(czy == 1){
                    this.zamow();
                }
            } else {
                if((Aplikacja.czas.getData().getDayOfMonth() == 1) && czy_nie_zaplacone){
                    System.out.println(this.getNazwa() + "Place");
                    this.zaplac(this.abonament.getCena());
                    czy_nie_zaplacone = false;
                }

                if(Aplikacja.czas.getData().getDayOfMonth()== 2){
                    czy_nie_zaplacone = true;
                }

                czy = generator.nextInt(20000000);
                if (czy == 1){
                    this.obejrzyj();
                }

            }
        }
        System.out.println(this.getNazwa() + " przerwany");
    }

    @Override
    public String toString() {
        return "KLIENT" + "\n" +
                "Nazwa: " + nazwa + "\n" +
                "Data urodzenia:" + data_urodzenia + "\n" +
                "Email: " + email + "\n" +
                "Nr karty: " + nr_karty + "\n" +
                "Abonament: " + abonament.getRodzaj();
    }
}
