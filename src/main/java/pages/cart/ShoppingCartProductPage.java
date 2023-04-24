package pages.cart;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ShoppingCartProductPage extends BasePage {

    public ShoppingCartProductPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = ".product-line-info>a")
    private WebElement cartProductName;

    @FindBy(css = ".current-price")
    private WebElement cartProductPrice;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement cartProductQuantity;

    @FindBy(css = "span.product-price")
    private WebElement cartProductsTotalPrice;
    @FindBy(css = ".remove-from-cart")
    private WebElement removeProductBtn;

    public void removeProduct() {
        waitForElementToBeClickable(removeProductBtn);
        click(removeProductBtn);
    }

    public String getCartProductName() {
        return getText(cartProductName);
    }

    public float getCartProductPrice() {
        return getPrice(cartProductPrice);
    }

    public int getCartProductQuantity() {
        return Integer.parseInt(cartProductQuantity.getAttribute("value"));
    }

    public float getCartProductTotalPrice() {
        return getPrice(cartProductsTotalPrice);
    }

    public Product getCartProductDetails() {
        return new Product(getCartProductName(), getCartProductPrice(), getCartProductQuantity(), getCartProductTotalPrice());
    }
}