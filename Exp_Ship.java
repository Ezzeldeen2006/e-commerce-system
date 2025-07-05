import java.time.LocalDate;

public class Exp_Ship extends Products implements IsExpirable,IsShipable{
    private LocalDate expDate;

    private double weight;

    public Exp_Ship(String name, float price, int quantity,LocalDate expDate, double weight) {
        super(name, price, quantity);
        this.expDate = expDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
