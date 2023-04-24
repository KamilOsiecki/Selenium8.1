package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CheckoutPaymentPage extends BasePage {
    public CheckoutPaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#payment-option-1")
    private WebElement paymentMethod;

    @FindBy(css = "section>p:nth-child(1)")
    private WebElement paymentAdditionalInformation;

    @FindBy(css = ".custom-checkbox>input")
    private WebElement termsOfServiceCheckbox;

    @FindBy(css = "#payment-confirmation .btn-primary ")
    private WebElement orderBtn;


    public CheckoutPaymentPage acceptTermsOfService() {
        click(termsOfServiceCheckbox);
        return this;
    }

    public CheckoutPaymentPage payByCheck() {
        click(paymentMethod);
        waitForElementToBeVisible(paymentAdditionalInformation);
        return this;
    }

    public void submitOrder() {
        click(orderBtn);
    }

}