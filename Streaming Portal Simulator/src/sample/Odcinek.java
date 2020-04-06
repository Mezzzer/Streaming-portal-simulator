package sample;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasa implementuja odcinkek serialu.
 */

public class Odcinek implements Serializable{
    LocalDate data;
    private double dlugosc;

    public Odcinek(double dlugosc, LocalDate data) {
        this.data = data;
        this.dlugosc = dlugosc;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(double dlugosc) {
        this.dlugosc = dlugosc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
