package pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SearchDropdownPage extends BasePage {
    public SearchDropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ui-id-1>li")
    private List<WebElement> searchResult;

    @FindBy(css = "li .product")
    private WebElement productName;

    public WebElement getProductName() {
        return productName;
    }

    public List<String> getSearchResults() {
        List<String> searchResultListElementPages = new ArrayList<>();
        waitForElementToBeVisible(productName);

        for (WebElement element : searchResult) {
            searchResultListElementPages.add(element.getText());
        }
        return searchResultListElementPages;
    }
}