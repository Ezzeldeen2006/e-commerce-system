import java.time.LocalDate;

public class Expirable_Products extends Products implements IsExpirable{

private LocalDate expDate;
    public Expirable_Products(String name, float price, int quantity, LocalDate expDate) {
        super(name, price, quantity);
        this.expDate = expDate;
    }
    @Override
    public LocalDate getExpirationDate() {
        return expDate;
    }
}
