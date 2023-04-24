package pages.search;

import configuration.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.Properties;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(xpath = "//button/i")
    private WebElement searchButton;

    @FindBy(css = "#js-category-list-header")
    private WebElement checkpointElement;

    public SearchPage provideProductName(String productName) {
        sendKeys(searchInput, productName);
        return this;
    }

    public String getCheckpointElementText() {
        return checkpointElement.getText();
    }

    public void initSearch() {
        click(searchButton);
    }
}