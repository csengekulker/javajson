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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRods() {
        return rods;
    }

    public void setRods(int rods) {
        this.rods = rods;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    
}
