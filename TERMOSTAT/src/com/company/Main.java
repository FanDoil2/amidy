package com.company;
import java.util.concurrent.TimeUnit;
public class Main {
    public Main() {
    }
    public static void main(String[] args) throws InterruptedException {
        Termostat termostat = new Termostat();
        while(true) {
            termostat.sprawdzTemperature();
            TimeUnit.SECONDS.sleep(1L);
        }
    }
}