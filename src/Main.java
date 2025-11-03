import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SystemZarzadzania system = new SystemZarzadzania();

        System.out.println("=== SYSTEM ZARZĄDZANIA PRACOWNIKAMI TECHCORP ===\n");

        System.out.println("1. DODAWANIE PRACOWNIKÓW:");

        Pracownik pracownik1 = new Pracownik("Piotr", "Kinowski", "p.kinowski@techcorp.pl",
                "TechCorp", Stanowisko.PREZES, 28000);
        system.addEmployee(pracownik1);

        Pracownik pracownik2 = new Pracownik("Anna", "Nowak", "a.nowak@techcorp.pl",
                "TechCorp", Stanowisko.WICEPREZES, 19000);
        system.addEmployee(pracownik2);

        Pracownik pracownik3 = new Pracownik("Jan", "Kowalski", "j.kowalski@techcorp.pl",
                "TechCorp", Stanowisko.MANAGER, 13000);
        system.addEmployee(pracownik3);

        Pracownik pracownik4 = new Pracownik("Maria", "Lewandowska", "m.lewandowska@techcorp.pl",
                "TechCorp", Stanowisko.PROGRAMISTA, 8500);
        system.addEmployee(pracownik4);

        Pracownik pracownik5 = new Pracownik("Krzysztof", "Wójcik", "k.wojcik@techcorp.pl",
                "TechCorp", Stanowisko.STAZYSTA, 3200);
        system.addEmployee(pracownik5);

        Pracownik pracownik6 = new Pracownik("Alicja", "Kamińska", "a.kaminska@innafirma.pl",
                "InnaFirma", Stanowisko.MANAGER, 12500);
        system.addEmployee(pracownik6);

        System.out.println("\nPróba dodania pracownika z istniejącym emailem:");
        Pracownik duplikat = new Pracownik("Adrian", "Nowak", "a.nowak@techcorp.pl",
                "TechCorp", Stanowisko.PROGRAMISTA, 8000);
        system.addEmployee(duplikat);

        System.out.println("\n\n2. LISTA WSZYSTKICH PRACOWNIKÓW:");
        system.wszyscyPracownicy();

        System.out.println("\n\n3. WYSZUKIWANIE PRACOWNIKÓW FIRMY 'TECHCORP':");
        List<Pracownik> techcorpPracownicy = system.pracownikPoFirmie("TechCorp");
        if (techcorpPracownicy.isEmpty()) {
            System.out.println("Brak pracowników w firmie TechCorp.");
        } else {
            for (Pracownik prac : techcorpPracownicy) {
                System.out.println(" - " + prac);
            }
        }

        System.out.println("\n\n4. PRACOWNICY POSORTOWANI PO NAZWISKU:");
        List<Pracownik> sortedEmployees = system.sortujPracownikowPoNazwisku();
        for (Pracownik prac : sortedEmployees) {
            System.out.println(" - " + prac.getNazwisko() + " " + prac.getImie() + " (" + prac.getEmail() + ")");
        }

        System.out.println("\n\n5. GRUPOWANIE PRACOWNIKÓW WEDŁUG STANOWISKA:");
        Map<Stanowisko, List<Pracownik>> pogrupowaniPoStanowisku = system.grupujPracownikowPoStanowisku();

        for (Map.Entry<Stanowisko, List<Pracownik>> entry : pogrupowaniPoStanowisku.entrySet()) {
            System.out.println("\n" + entry.getKey() + ":");
            for (Pracownik prac : entry.getValue()) {
                System.out.println("   - " + prac.getImie() + " " + prac.getNazwisko() +
                        " (" + prac.getFirma() + ")");
            }
        }

        System.out.println("\n\n6. LICZBA PRACOWNIKÓW NA POSZCZEGÓLNYCH STANOWISKACH:");
        Map<Stanowisko, Integer> liczbaNaStanowisku = system.liczPracownikowPoStanowisku();

        for (Map.Entry<Stanowisko, Integer> entry : liczbaNaStanowisku.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " pracowników");
        }

        System.out.println("\n\n7. STATYSTYKI FINANSOWE:");

        double sredniaPensja = system.sredniaPensja();
        System.out.printf(" - Średnie wynagrodzenie w organizacji: %.2f PLN\n", sredniaPensja);

        Pracownik najwyzszaPensja = system.znajdzPracownikaZNajwyzszaPensja();
        if (najwyzszaPensja != null) {
            System.out.println(" - Pracownik z najwyższym wynagrodzeniem:");
            System.out.println("   " + najwyzszaPensja.getImie() + " " + najwyzszaPensja.getNazwisko() +
                    " - " + najwyzszaPensja.getStanowisko() + " - " +
                    najwyzszaPensja.getPensja() + " PLN");
        }

        System.out.println("\n\n8. DODATKOWE ANALIZY:");

        SystemZarzadzania techcorpSystem = new SystemZarzadzania();
        for (Pracownik prac : system.getPracownicy()) {
            if (prac.getFirma().equals("TechCorp")) {
                techcorpSystem.addEmployee(prac);
            }
        }

        double techcorpSrednia = techcorpSystem.sredniaPensja();
        System.out.printf(" - Średnie wynagrodzenie w TechCorp: %.2f PLN\n", techcorpSrednia);

        System.out.println("\nBAZOWE STAWKI WYNAGRODZEŃ DLA STANOWISK:");
        for (Stanowisko stanowisko : Stanowisko.values()) {
            System.out.printf(" - %s: %.2f PLN\n", stanowisko.getNazwa(), stanowisko.getPensja());
        }

        System.out.println("\n=== KONIEC RAPORTU ===");
    }
}