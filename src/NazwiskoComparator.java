import java.util.Comparator;

public class NazwiskoComparator implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik emp1, Pracownik emp2) {
        return emp1.getNazwisko().compareTo(emp2.getNazwisko());
    }
}