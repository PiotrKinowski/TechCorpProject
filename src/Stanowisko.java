public enum Stanowisko {
    PREZES("Prezes", 25000, 1),
    WICEPREZES("Wiceprezes", 18000, 2),
    MANAGER("Manager", 12000, 3),
    PROGRAMISTA("Programista", 8000, 4),
    STAZYSTA("Stażysta", 3000, 5);

    private final String nazwa;
    private final double pensja;
    private final int poziom;

    Stanowisko(String nazwa, double pensja, int poziom) {
        this.nazwa = nazwa;
        this.pensja = pensja;
        this.poziom = poziom;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getPensja() {
        return pensja;
    }

    public int getPoziom() {
        return poziom;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}