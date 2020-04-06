package sample;

import java.io.Serializable;

/**
 * Klasa implementujaca rozdzielczosc potrzebna w abomamencie.
 */

public class Rozdzielczosc implements Serializable{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rozdzielczosc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
