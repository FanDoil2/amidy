package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Rezerwa {
    private static List<Sala> saleLekcyjne = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Rezerwacja sali");
            System.out.println("2. Sprawdzenie dostępności sali");
            System.out.println("3. Dodanie nowej sali");
            System.out.println("4. Edycja pojemności sali");
            System.out.println("5. Wyjście");
            int wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor) {
                case 1:
                    zarezerwujSale();
                    break;
                case 2:
                    sprawdzDostepnoscSali();
                    break;
                case 3:
                    dodajSale();
                    break;
                case 4:
                    edytujPojemnosc();
                    break;
                case 5:
                    System.out.println("Dziękujemy za korzystanie z systemu rezerwacji sal lekcyjnych!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
            }
        }
    }
    private static void zarezerwujSale() {
        System.out.print("Podaj numer sali: ");
        String numerSali = scanner.nextLine();

        System.out.print("Podaj datę i godzinę rezerwacji (np. '2023-10-05 14:00'): ");
        String dataGodzina = scanner.nextLine();

        Sala sala = znajdzSale(numerSali);

        if (sala != null && sala.czyDostepna(dataGodzina)) {
            sala.zarezerwuj(dataGodzina);
            System.out.println("Rezerwacja sali nr " + numerSali + " na " + dataGodzina + " została potwierdzona.");
        } else {
            System.out.println("Sala jest już zajęta lub nie istnieje. Rezerwacja nieudana.");
        }
    }
    private static void sprawdzDostepnoscSali() {
        System.out.print("Podaj numer sali: ");
        String numerSali = scanner.nextLine();

        System.out.print("Podaj datę i godzinę (np. '2023-10-05 14:00'): ");
        String dataGodzina = scanner.nextLine();

        Sala sala = znajdzSale(numerSali);

        if (sala != null && sala.czyDostepna(dataGodzina)) {
            System.out.println("Sala nr " + numerSali + " jest dostępna na " + dataGodzina + ".");
        } else {
            System.out.println("Sala jest zajęta lub nie istnieje.");
        }
    }
    private static void dodajSale() {
        System.out.print("Podaj numer nowej sali: ");
        String numerSali = scanner.nextLine();
        System.out.print("Podaj pojemność nowej sali: ");
        int pojemnosc = scanner.nextInt();
        scanner.nextLine();
        Sala sala = new Sala(numerSali, pojemnosc);
        saleLekcyjne.add(sala);
        System.out.println("Dodano nową salę nr " + numerSali + " o pojemności " + pojemnosc + ".");
    }
    private static void edytujPojemnosc() {
        System.out.print("Podaj numer sali, której pojemność chcesz zmienić: ");
        String numerSali = scanner.nextLine();
        Sala sala = znajdzSale(numerSali);
        if (sala != null) {
            System.out.print("Nowa pojemność sali: ");
            int nowaPojemnosc = scanner.nextInt();
            scanner.nextLine();
            sala = new Sala(numerSali, nowaPojemnosc);
            System.out.println("Zmieniono pojemność sali nr " + numerSali + " na " + nowaPojemnosc + ".");
        } else {
            System.out.println("Sala o podanym numerze nie istnieje.");
        }
    }
    private static Sala znajdzSale(String numerSali) {
        for (Sala sala : saleLekcyjne) {
            if (sala.getNumerSali().equalsIgnoreCase(numerSali)) {
                return sala;
            }
        }
        return null;
    }
}