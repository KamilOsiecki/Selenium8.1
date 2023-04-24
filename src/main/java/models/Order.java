package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if (product.getName().equals(productToAdd.getName())) {
                int quantityTest = product.setQuantity(productToAdd.getQuantity());
                product.setTotalPrice(quantityTest);
                return;
            }
        }
        products.add(productToAdd);
    }
}