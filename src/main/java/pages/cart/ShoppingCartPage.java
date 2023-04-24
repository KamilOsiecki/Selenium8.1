package pages.cart;

import models.Order;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-products-count")
    private WebElement cartProductCounter;

    @FindBy(css = "a.btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".cart-items>li")
    private List<WebElement> cartProducts;

    @FindBy(css = ".cart-total>.value")
    private WebElement orderTotalPrice;

    @FindBy(css = "#cart-subtotal-shipping>span.value")
    private WebElement shippingCost;

    @FindBy(css = ".no-items")
    private WebElement noItemsLabel;

    public String getNoItemsMessage() {
        waitForElementToBeVisible(noItemsLabel);
        return getText(noItemsLabel);
    }

    public void goToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public int getCartProductsNumber() {
        return Integer.parseInt(StringUtils.substring(getText(cartProductCounter), 1, getText(cartProductCounter).length() - 1));
    }

    public Order getOrder() {
        Order order = new Order();
        for (WebElement cartProduct : cartProducts) {
            ShoppingCartProductPage product = new ShoppingCartProductPage(driver, cartProduct);
            order.addProduct(product.getCartProductDetails());
        }
        return order;
    }

    public float getOrderTotalPrice() {
        return getPrice(orderTotalPrice);
    }

    public float getCartsProductsTotalPrice() {
        float totalPrice = 0.0f;
        for (WebElement cartProduct : cartProducts) {
            ShoppingCartProductPage product = new ShoppingCartProductPage(driver, cartProduct);
            totalPrice += product.getCartProductTotalPrice();
        }
        return totalPrice + getShippingCost();
    }

    public float getShippingCost() {
        if (getText(shippingCost).equals("Free")) {
            return 0;
        } else
            return getPrice(shippingCost);
    }

    public void removeProductFromCart(int productIndex) {
        if (productIndex < 0 || productIndex >= cartProducts.size()) {
            System.out.println("Invalid product index");
            return;
        }
        ShoppingCartProductPage product = new ShoppingCartProductPage(driver, cartProducts.get(productIndex));
        product.removeProduct();
    }
}