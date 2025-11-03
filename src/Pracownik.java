public class Pracownik {
    private String imie;
    private String nazwisko;
    private String email;
    private String firma;
    private Stanowisko stanowisko;
    private double pensja;

    public Pracownik(String imie, String nazwisko, String email,
                     String firma, Stanowisko stanowisko, double pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.firma = firma;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public String getFirma() {
        return firma;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pracownik pracownik = (Pracownik) obj;
        return email.equals(pracownik.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) - %s, %s, %.2f PLN",
                imie, nazwisko, email, firma, stanowisko, pensja);
    }
}