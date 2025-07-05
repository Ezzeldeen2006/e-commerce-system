import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        Customer customer = new Customer("Ahmed", 50000);
        Products cheese = new Exp_Ship("Cheese", 100, 10, LocalDate.of(2026, 12, 31), 200);
        Products tv = new Shipable_Products("TV", 5000, 5, 8000);
        Products scratchCard = new Products("ScratchCard", 20, 100);
        Products biscuits = new Exp_Ship("Biscuits", 150, 20, LocalDate.of(2025, 10, 20), 700);
        Products laptop = new Shipable_Products("Laptop", 800, 5, 2000);
        Products giftCard = new Products("GiftCard", 50, 50);

        customer.add(cheese, 2);
        customer.add(biscuits, 1);
        customer.add(tv, 2);
        customer.add(laptop, 1);
        customer.add(scratchCard, 5);
        customer.add(giftCard, 2);
        checkout.checkout(customer);

    }
}
