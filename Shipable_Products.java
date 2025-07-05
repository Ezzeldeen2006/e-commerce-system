public class Shipable_Products extends Products implements IsShipable{
    private double weight;
    public Shipable_Products(String name, float price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}


