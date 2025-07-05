import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Cart> cart;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new ArrayList<>();

    }
    public void add(Products product, int quantity)
    {
        if(quantity> product.getQuantity())
            return;
        for (Cart item : cart) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        cart.add(new Cart(product, quantity));
    }


}


