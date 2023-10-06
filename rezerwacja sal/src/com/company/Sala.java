package com.company;

import java.util.HashMap;
import java.util.Map;

public class Sala {
    private String numerSali;
    private int pojemnosc;
    private Map<String, Boolean> rezerwacje;

    public Sala(String numerSali, int pojemnosc) {
        this.numerSali = numerSali;
        this.pojemnosc = pojemnosc;
        this.rezerwacje = new HashMap<>();
    }

    public String getNumerSali() {
        return numerSali;
    }

    public boolean czyDostepna(String dataGodzina) {
        return !rezerwacje.containsKey(dataGodzina) || !rezerwacje.get(dataGodzina);
    }

    public void zarezerwuj(String dataGodzina) {
        rezerwacje.put(dataGodzina, true);
    }

}