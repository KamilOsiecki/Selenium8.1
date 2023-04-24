package pages.product;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement productName;

    @FindBy(css = ".current-price>span:nth-of-type(1)")
    private WebElement price;
    @FindBy(css = "#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    public String getProductName() {
        return getText(productName);
    }

    public float getProductPrice() {
        return getPrice(price);
    }

    public int getQuantity() {
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public float getTotalPrice() {
        return getProductPrice() * getQuantity();
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    public ProductDetailsPage setQuantity(int quantity) {
        sendKeysAndClear(quantityInput, String.valueOf(quantity));
        return this;
    }

    public Product getProductDetails() {
        return new Product(getProductName(), getProductPrice(), getQuantity(), getTotalPrice());
    }
}