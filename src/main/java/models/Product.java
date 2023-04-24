package models;

public class Product {

    private String name;
    private float price;
    private int quantity;
    private float totalPrice;

    public Product(String name, float price, int quantity, float totalPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return quantity * price;
    }

    public int setQuantity(int quantity) {
        return this.quantity += quantity;
    }

    public float setTotalPrice(int totalPrice) {
        return this.totalPrice = this.totalPrice + totalPrice;
    }

    @Override
    public String toString() {
        return "Name " + name +
                " price: " + price +
                " quantity: " + quantity +
                " totalPrice: " + totalPrice;
    }
}