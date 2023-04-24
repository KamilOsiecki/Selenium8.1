package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class UserAccountPage extends BasePage {
    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#my-account")
    private WebElement myAccountLabel;

    public Boolean isMyAccountLabelDisplayed() {
        return isDisplayed(myAccountLabel);
    }
}