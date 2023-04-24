package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement orderConfirmationLabel;

    public String getOrderConfirmationMessage() {
        waitForElementToBeVisible(orderConfirmationLabel);
        return getText(orderConfirmationLabel).substring(1);
    }
}
