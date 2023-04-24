package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = "input.form-control[name='email']")
    private WebElement emailInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[name='customer_privacy']")
    private WebElement customerPrivacyCheckbox;

    @FindBy(css = "input[name='psgdpr']")
    private WebElement generalTermsCheckbox;

    @FindBy(css = ".form-control-submit")
    private WebElement submitFormBtn;

    public String getFirstNameInput() {
        return getText(firstNameInput);
    }

    public String getLastNameInput() {
        return getText(lastNameInput);
    }

    public String getEmail() {
        return getText(emailInput);
    }

    public String getPassword() {
        return getText(passwordInput);
    }

    public void acceptCustomerPrivacy() {
        click(customerPrivacyCheckbox);
    }

    public void acceptGeneralTerms() {
        click(generalTermsCheckbox);
    }

    public void submitNewUserForm() {
        click(submitFormBtn);
    }

    public void registerNewUser(User user) {
        if (!user.getFirstName().isEmpty()) {
            sendKeys(firstNameInput, user.getFirstName());
        }
        if (!user.getLastName().isEmpty()) {
            sendKeys(lastNameInput, user.getLastName());
        }

        if (!user.getEmail().isEmpty()) {
            sendKeys(emailInput, user.getEmail());
        }
        if (!user.getPassword().isEmpty()) {
            sendKeys(passwordInput, user.getPassword());
        }
        acceptCustomerPrivacy();
        acceptGeneralTerms();
        submitNewUserForm();
    }
}
