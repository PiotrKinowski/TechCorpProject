import java.util.*;

public class SystemZarzadzania {
    private List<Pracownik> pracownicy;

    public SystemZarzadzania() {
        this.pracownicy = new ArrayList<>();
    }

    public boolean addEmployee(Pracownik nowyPracownik) {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getEmail().equals(nowyPracownik.getEmail())) {
                System.out.println("Błąd: Pracownik z emailem " + nowyPracownik.getEmail() + " już istnieje!");
                return false;
            }
        }
        pracownicy.add(nowyPracownik);
        return true;
    }

    public void wszyscyPracownicy() {
        System.out.println("\n=== LISTA WSZYSTKICH PRACOWNIKÓW ===");
        if (pracownicy.isEmpty()) {
            System.out.println("Brak pracowników w systemie.");
            return;
        }

        for (int i = 0; i < pracownicy.size(); i++) {
            System.out.println((i + 1) + ". " + pracownicy.get(i));
        }
    }

    public List<Pracownik> pracownikPoFirmie(String company) {
        List<Pracownik> result = new ArrayList<>();
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getFirma().equalsIgnoreCase(company)) {
                result.add(pracownik);
            }
        }
        return result;
    }

    public List<Pracownik> sortujPracownikowPoNazwisku() {
        List<Pracownik> posortowanaLista = new ArrayList<>(pracownicy);
        Collections.sort(posortowanaLista, new NazwiskoComparator());
        return posortowanaLista;
    }

    public Map<Stanowisko, List<Pracownik>> grupujPracownikowPoStanowisku() {
        Map<Stanowisko, List<Pracownik>> pogrupowane = new HashMap<>();

        for (Pracownik pracownik : pracownicy) {
            Stanowisko stanowisko = pracownik.getStanowisko();
            if (!pogrupowane.containsKey(stanowisko)) {
                pogrupowane.put(stanowisko, new ArrayList<>());
            }
            pogrupowane.get(stanowisko).add(pracownik);
        }

        return pogrupowane;
    }

    public Map<Stanowisko, Integer> liczPracownikowPoStanowisku() {
        Map<Stanowisko, Integer> liczba = new HashMap<>();

        for (Pracownik pracownik : pracownicy) {
            Stanowisko position = pracownik.getStanowisko();
            if (!liczba.containsKey(position)) {
                liczba.put(position, 0);
            }
            liczba.put(position, liczba.get(position) + 1);
        }

        return liczba;
    }

    public double sredniaPensja() {
        if (pracownicy.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (Pracownik pracownik : pracownicy) {
            suma += pracownik.getPensja();
        }

        return suma / pracownicy.size();
    }

    public Pracownik znajdzPracownikaZNajwyzszaPensja() {
        if (pracownicy.isEmpty()) {
            return null;
        }

        Pracownik najwyzszaPensja = pracownicy.get(0);
        for (int i = 1; i < pracownicy.size(); i++) {
            if (pracownicy.get(i).getPensja() > najwyzszaPensja.getPensja()) {
                najwyzszaPensja = pracownicy.get(i);
            }
        }

        return najwyzszaPensja;
    }

    public List<Pracownik> getPracownicy() {
        return new ArrayList<>(pracownicy);
    }
}