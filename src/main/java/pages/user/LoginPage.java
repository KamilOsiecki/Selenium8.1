package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.col-md-6>input")
    private WebElement emailInput;

    @FindBy(css = "div.col-md-6>div>input")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement signInBtn;

    @FindBy(css = ".no-account>a")
    private WebElement noAccountLink;

    public void goToUserAccountCreation() {
        click(noAccountLink);
    }

    public LoginPage setEmail(String email) {
        sendKeys(emailInput, email);
        return this;
    }

    public LoginPage setPassword(String password) {
        sendKeys(passwordInput, password);
        return this;
    }

    public void sigIn() {
        click(signInBtn);
    }
}