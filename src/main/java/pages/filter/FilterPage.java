package pages.filter;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class FilterPage extends BasePage {

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_filters")
    private WebElement searchFilter;
    @FindBy(css = ".ui-slider>a:nth-of-type(1)")
    private WebElement leftSliderHandle;

    @FindBy(css = ".ui-slider>a:nth-of-type(2)")
    private WebElement rightSliderHandle;

    @FindBy(css = ".faceted-slider>li>p")
    private WebElement priceRangeLabel;

    @FindBy(css = ".faceted-slider")
    private WebElement priceFilter;

    @FindBy(css = ".close")
    private WebElement clearFilterButton;

    public void isSearchFilterDisplayed() {
        searchFilter.isDisplayed();
    }

    public float getLeftHandleValue() {
        return getHandlesValue(0);
    }

    public FilterPage moveLeftSliderBy(float selectedValue, Keys key) {
        float handleValue = getLeftHandleValue();
        for (float i = handleValue; i < selectedValue; i++) {
            scrollToElement(priceFilter);
            waitForElementToBeClickableBool(leftSliderHandle);
            actions.clickAndHold(leftSliderHandle).sendKeys(key).release(leftSliderHandle).perform();
            handleValue++;
        }
        return this;
    }

    public FilterPage moveLeftSliderTo(float expectedSliderValue) {
        if (expectedSliderValue > getLeftHandleValue()) {
            waitForElementToBeClickableBool(priceFilter);
            moveLeftSliderBy(expectedSliderValue, Keys.ARROW_RIGHT);
        } else if (expectedSliderValue < getLeftHandleValue()) {
            waitForElementToBeClickableBool(priceFilter);
            moveLeftSliderBy(expectedSliderValue, Keys.ARROW_LEFT);
        }
        return this;
    }

    public float getRightHandleValue() {
        return getHandlesValue(1);
    }

    public FilterPage moveRightSliderBy(float selectedValue, Keys key) {
        float handleValue = getRightHandleValue();
        for (float i = handleValue; i > selectedValue; i--) {
            waitForElementToBeClickableBool(rightSliderHandle);
            scrollToElement(priceFilter);
            actions.clickAndHold(rightSliderHandle).sendKeys(key).release(rightSliderHandle).perform();
            handleValue--;
        }
        return this;
    }

    public FilterPage moveRightSliderTo(float expectedSliderValue) {
        if (expectedSliderValue > getRightHandleValue()) {
            waitForElementToBeClickableBool(priceFilter);
            moveRightSliderBy(expectedSliderValue, Keys.ARROW_RIGHT);
        } else if (expectedSliderValue < getRightHandleValue()) {
            waitForElementToBeClickableBool(priceFilter);
            moveRightSliderBy(expectedSliderValue, Keys.ARROW_LEFT);
        }
        return this;
    }

    public float getHandlesValue(int stringNumber) {
        waitForElementToBeClickableBool(priceRangeLabel);
        String value = priceRangeLabel.getText();
        String[] value2 = value.split(" - ");
        return Float.parseFloat(value2[stringNumber].substring(1));
    }

    public FilterPage clearFilter() {
        waitForElementToBeClickableBool(clearFilterButton);
        click(clearFilterButton);
        wait.until(ExpectedConditions.invisibilityOf(clearFilterButton));
        return this;
    }
}