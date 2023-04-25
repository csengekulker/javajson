import java.time.LocalDate;

public class FishingSpot {
    int id;
    String name;
    int spot;
    LocalDate date;
    int rods;
    boolean paid;

    public FishingSpot(int id, String name, int spot, LocalDate date, int rods, boolean paid) {
        this.id = id;
        this.name = name;
        this.spot = spot;
        this.date = date;
        this.rods = rods;
        this.paid = paid;
    }
}
