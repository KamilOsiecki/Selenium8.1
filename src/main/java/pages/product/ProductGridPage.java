package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-description")
    private List<WebElement> productMiniatures;

    public List<ProductMiniaturePage> getProducts() {
        List<ProductMiniaturePage> productMiniaturePages = new ArrayList<>();

        for (WebElement element : productMiniatures) {
            productMiniaturePages.add(new ProductMiniaturePage(driver, element));
        }
        return productMiniaturePages;
    }

    public String getRandomProductName() {
        ProductMiniaturePage product = new ProductMiniaturePage(driver, getRandomElement(productMiniatures));
        return product.getTitle();
    }

    public int getProductsListSize() {
        return productMiniatures.size();
    }

    public int filterProductsByPrice(float lowerHandleValue, float higherHandleValue) {
        return (int) getProducts().stream()
                .filter(products -> products.getPrice() >= lowerHandleValue)
                .filter(products -> products.getPrice() <= higherHandleValue)
                .count();
    }

    public void openProduct(String productName) {
        for (ProductMiniaturePage productMiniaturePage : getProducts()) {
            if (productMiniaturePage.getTitle().equals(productName)) {
                productMiniaturePage.goToProduct();
                break;
            }
        }
    }

    public ProductGridPage openRandomProduct() {
        ProductMiniaturePage product = new ProductMiniaturePage(driver, getRandomElement(productMiniatures));
        product.goToProduct();
        return this;
    }
}