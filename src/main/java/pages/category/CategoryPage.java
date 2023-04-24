package pages.category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;


public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement categoryNameHeader;

    @FindBy(css = ".total-products>p")
    private WebElement numberOfProductsText;

    @FindBy(css = ".category-sub-menu>li")
    private List<WebElement> subCategories;

    public List<WebElement> getSubCategories() {
        return new ArrayList<>(subCategories);
    }

    public int getSubCategoriesSize() {
        return subCategories.size();
    }

    public CategoryPage goToSubCategory(int i) {
        click(subCategories.get(i));
        return this;
    }

    public String getSubCategoryName(int i) {
        return getSubCategories().get(i).getText().toLowerCase();
    }

    public Boolean isSubCategoryExist() {
        return getSubCategories().size() > 0;
    }

    public String getCategoryNameHeader() {
        return getText(categoryNameHeader).toLowerCase();
    }

    public String numberOfProductsText() {
        return getText(numberOfProductsText);
    }
}