import java.util.Scanner;

class Kwadrat {
    double bok;
    Kwadrat(double bok) { 
        this.bok = bok; 
    }
    double obliczPole() { 
        return bok * bok; 
    }
}

class Prostokat {
    double dlugosc, szerokosc;
    Prostokat(double dlugosc, double szerokosc) { 
        this.dlugosc = dlugosc; this.szerokosc = szerokosc; 
    }
    double obliczPole() { 
        return dlugosc * szerokosc; 
    }
}

class Trojkat {
    double podstawa, wysokosc;
    Trojkat(double podstawa, double wysokosc) {
     this.podstawa = podstawa; this.wysokosc = wysokosc; 
    }
    double obliczPole() { 
        return 0.5 * podstawa * wysokosc; 
    }
}

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Kwadrat 2. Prostokąt 3. Trójkąt 4. Wyjście");
            System.out.print("Wybór: ");
            int wybor = scanner.nextInt();

            if (wybor == 4) { System.out.println("Dziękujemy. Do widzenia!"); break; }

            switch (wybor) {
                case 1: System.out.print("Długość boku: "); System.out.println("Pole kwadratu: " + new Kwadrat(scanner.nextDouble()).obliczPole()); break;
                case 2: System.out.print("Długość i szerokość: "); System.out.println("Pole prostokąta: " + new Prostokat(scanner.nextDouble(), scanner.nextDouble()).obliczPole()); break;
                case 3: System.out.print("Podstawa i wysokość: "); System.out.println("Pole trójkąta: " + new Trojkat(scanner.nextDouble(), scanner.nextDouble()).obliczPole()); break;
                default: System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }

        scanner.close();
    }
}