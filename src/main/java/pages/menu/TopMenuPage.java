package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#top-menu>.category")
    private List<WebElement> categoryList;

    @FindBy(css = "#top-menu>.category")
    private WebElement category;
    @FindBy(css = "#category-6")
    private WebElement accessoriesTabLabel;

    @FindBy(css = "#category-9")
    private WebElement artTabLabel;

    @FindBy(css = ".user-info>a")
    private WebElement signInButton;

    @FindBy(css = ".logout")
    private WebElement signOutButton;

    public void goToSignInPage() {
        click(signInButton);
    }

    public Boolean isLogoutButtonDisplayed() {
        return isDisplayed(signInButton);
    }

    public void goToArt() {
        click(artTabLabel);
    }

    public void goToAccessories() {
        click(accessoriesTabLabel);
    }

    public List<WebElement> getCategories() {
        return new ArrayList<>(categoryList);
    }

    public int getCategoriesSize() {
        return categoryList.size();
    }

    public String getCategoryName(int i) {
        return getCategories().get(i).getText().toLowerCase();
    }

    public void goToCategory(int i) {
        click(categoryList.get(i));
    }
}