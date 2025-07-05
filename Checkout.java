import java.util.List;

public class Checkout {
    private ShippingService shippingService;

    public Checkout() {
        this.shippingService = new ShippingService();
    }

    public void checkout(Customer customer) {
        List<Cart> cart = customer.getCart();

        if (cart.isEmpty()) {
            return;
        }

        for (Cart item : cart) {
            Products product = item.getProduct();
            if (item.getQuantity() > product.getQuantity()) {
                return;
            }
            if (product instanceof IsExpirable && ((IsExpirable) product).isExpired()) {
                return;
            }
        }

        double shippingFees = shippingService.processShipment(cart);

        double subtotal = 0;
        System.out.println("** Checkout receipt **");
        for (Cart item : cart) {
            System.out.printf("%dx %-10s %7.0f%n", item.getQuantity(), item.getProduct().getName(), item.TotalPrice());
            subtotal += item.TotalPrice();
        }

        double totalAmount = subtotal + shippingFees;
        if (customer.getBalance() < totalAmount) {
            System.out.printf("%-10s %15.0f%n", "Your Balance", customer.getBalance());
            System.out.printf("%-10s %15.0f%n", "Shortage", totalAmount - customer.getBalance());
            System.out.println("** PAYMENT FAILED: Insufficient Balance **");
            return;

        }

        System.out.println("-------------------------");
        System.out.printf("%-10s %15.0f%n", "Subtotal", subtotal);
        System.out.printf("%-10s %15.0f%n", "Shipping", shippingFees);
        System.out.printf("%-10s %15.0f%n", "Amount", totalAmount);

        customer.setBalance(customer.getBalance() - totalAmount);
        for (Cart item : cart) {
            Products product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }

        cart.clear();
        System.out.println("** PAYMENT SUCCESSFUL **");
        System.out.printf("Remaining Balance: %.0f%n", customer.getBalance());
    }
}
