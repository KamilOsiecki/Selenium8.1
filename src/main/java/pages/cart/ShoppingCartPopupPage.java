package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ShoppingCartPopupPage extends BasePage {
    public ShoppingCartPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#myModalLabel")
    private WebElement confirmationMessage;

    @FindBy(css = ".product-quantity>strong")
    private WebElement productQuantity;

    @FindBy(css = "p.product-price")
    private WebElement productPrice;

    @FindBy(css = "p.cart-products-count")
    private WebElement productsCounterMessage;

    @FindBy(css = ".subtotal.value")
    private WebElement subTotalPrice;

    @FindBy(css = ".product-total>.value")
    private WebElement totalProductsPrice;

    @FindBy(css = "a.btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;

    @FindBy(css = ".shipping.value")
    private WebElement shippingValue;

    public float getShippingValue() {
        return getPrice(shippingValue);
    }

    public float getSubTotalPrice() {
        return getPrice(subTotalPrice);
    }

    public float getTotalPrice() {
        return getPrice(totalProductsPrice);
    }

    public void continueShopping() {
        waitForElementToBeClickableBool(proceedToCheckoutBtn);
        click(continueShoppingButton);
    }

    public void proceedToCheckout() {
        waitForElementToBeClickableBool(proceedToCheckoutBtn);
        click(proceedToCheckoutBtn);
    }

    public String getProductsCounterMessage() {
        return getText(productsCounterMessage);
    }

    public float getProductPrice() {
        return getPrice(productPrice);
    }

    public int getProductQuantity() {
        return Integer.parseInt(getText(productQuantity));
    }

    public String getProductLabelText() {
        waitForElementToBeVisible(confirmationMessage);
        return getText(confirmationMessage).substring(1);
    }

    public float totalProductValue() {
        float subTotal = getProductPrice() * getProductQuantity();
        float shippingCost = getShippingValue();
        return subTotal + shippingCost;
    }
}