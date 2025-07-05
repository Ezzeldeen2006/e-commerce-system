import java.util.List;
import java.util.stream.Collectors;

public class ShippingService {
    private  int shippingFee=30;
    public int processShipment(List<Cart> cart) {
        List<Cart> shippableItems = cart.stream().filter(item -> item.getProduct() instanceof IsShipable).collect(Collectors.toList());

        if (shippableItems.isEmpty()) {
            return 0;
        }

        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Cart item : shippableItems) {
            IsShipable shippable = (IsShipable) item.getProduct();
            double itemTotalWeight = shippable.getWeight() * item.getQuantity();
            totalWeight += itemTotalWeight;
            System.out.printf("%dx %-10s %5.0fg%n", item.getQuantity(), shippable.getName(), itemTotalWeight);
        }

        System.out.printf("Total package weight %.1fkg%n%n", totalWeight / 1000.0);

        return shippingFee;
    }

}
