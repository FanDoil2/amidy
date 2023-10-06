package com.company;

import java.util.concurrent.TimeUnit;

public class Termostat {
    private int aktualna = 14;
    private int ustawiona = 20;
    private boolean ogrzewanie = false;
    private boolean chlodzenie = false;
    Termostat() {
    }
    public void wlaczOgrzewanie() {
        if (!this.ogrzewanie) {
            this.ogrzewanie = true;
            this.chlodzenie = false;
            System.out.println("ogrzewanie włączone");
        }
    }
    public void wlaczChlodzenie() {
        if (!this.chlodzenie) {
            this.chlodzenie = true;
            this.ogrzewanie = false;
            System.out.println("chłodzenie włączone");
        }
    }
    public void wylaczOgrzewanie() {
        if (this.ogrzewanie) {
            this.ogrzewanie = false;
            System.out.println("ogrzewanie wyłączone");
        }
    }
    public void wylaczChlodzenie() {
        if (this.chlodzenie) {
            this.chlodzenie = false;
            System.out.println("chłodzenie wyłączone");
        }

    }
    public void sprawdzTemperature() throws InterruptedException {
        if (this.aktualna < this.ustawiona) {
            System.out.println("Aktualna temperatura wynosi: " + this.aktualna);
            System.out.println("Podana temperatura: " + this.ustawiona);
            this.wlaczOgrzewanie();
            while (this.aktualna < this.ustawiona) {
                ++this.aktualna;
                System.out.println("Aktualna temperatura wynosi: " + this.aktualna);
                TimeUnit.SECONDS.sleep(1L);
            }
            this.wylaczOgrzewanie();
        } else if (this.aktualna > this.ustawiona) {
            System.out.println("Aktualna temperatura wynosi: " + this.aktualna);
            System.out.println("Podana temperatura: " + this.ustawiona);
            this.wlaczChlodzenie();
            while (this.aktualna > this.ustawiona) --this.aktualna;
            System.out.println("Aktualna temperatura wynosi: " + this.aktualna);
            TimeUnit.SECONDS.sleep(1L);
        }
        this.wylaczChlodzenie();
    }

}
}
