package sample;

import java.io.Serializable;
import java.util.Random;

/**
 * Enum sposrod ktorego wartosci jest wybierany gatunek
 */

public enum Gatunek implements Serializable{
    Sensacyjny, Dramat, Komedia, Dla_dzieci, Dokumentalny, Akcji;

    public static Gatunek losuj_gatunek(){
        Random generator = new Random();
        return values()[generator.nextInt(values().length)];
    }
}
