package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CheckoutShippingPage extends BasePage {
    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".col-sm-1")
    private List<WebElement> shippingMethods;

    @FindBy(css = "button[name='confirmDeliveryOption']")
    private WebElement continueBtn;

    @FindBy(css = "#delivery_message")
    private WebElement deliveryMessage;

    public CheckoutShippingPage setRandomShippingMethod() {
        click(getRandomElement(shippingMethods));
        return this;
    }

    public void confirmDeliveryOption() {
        click(continueBtn);
    }

    public CheckoutShippingPage setDeliveryMessage(String deliveryMessage) {
        sendKeys(this.deliveryMessage, deliveryMessage);
        return this;
    }
}