package pages.checkout;

import models.Invoice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CheckoutAddressPage extends BasePage {
    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "p:nth-child(5)>a")
    private WebElement differentBillingAddressLink;

    @FindBy(css = "input[name='alias']")
    private WebElement aliasInput;

    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = "input[name='company']")
    private WebElement companyInput;

    @FindBy(css = "input[name='vat_number']")
    private WebElement vatNumberInput;

    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;

    @FindBy(css = "input[name='address2']")
    private WebElement addressComplementInput;

    @FindBy(css = "input[name='postcode']")
    private WebElement postCodeInput;

    @FindBy(css = "input[name='city']")
    private WebElement cityInput;

    @FindBy(css = ".form-control-select>option")
    private List<WebElement> countries;
    @FindBy(css = "input[name='phone']")
    private WebElement phoneInput;

    @FindBy(css = ".form-footer>.btn-primary")
    private WebElement firstInvoiceContinueBtn;

    @FindBy(css = ".clearfix>button")
    private WebElement nextInvoiceContinueBtn;

    @FindBy(css = "#invoice-address")
    private WebElement invoiceForm;

    @FindBy(css = ".add-address>a")
    private WebElement addNewAddressLink;

    @FindBy(css = "#use_same_address")
    private WebElement useThisInvoiceAddressCheckbox;

    @FindBy(css = ".form-footer>button")
    private WebElement saveNewInvoiceAddressBtn;

    public void saveNewInvoiceAddress() {
        click(saveNewInvoiceAddressBtn);
    }

    public void setInvoiceAddress() {
        click(useThisInvoiceAddressCheckbox);
    }

    public void confirmAddress() {
        scrollToElement(firstInvoiceContinueBtn);
        click(firstInvoiceContinueBtn);
    }

    public void confirmNewAddress() {
        click(nextInvoiceContinueBtn);
    }

    public void setRandomCountry() {
        int countryIndex = random.nextInt(1, countries.size());
        countries.get(countryIndex).click();
    }

    public CheckoutAddressPage goToInvoiceAddressForm() {
        click(differentBillingAddressLink);
        return this;
    }

    public CheckoutAddressPage fillInvoiceForm(Invoice invoice) {

        if (!invoice.getAlias().isEmpty()) {
            sendKeys(aliasInput, invoice.getAlias());
        }
        if (!invoice.getFirstName().isEmpty() && !firstNameInput.getText().isEmpty()) {
            sendKeys(firstNameInput, invoice.getFirstName());
        }

        if (!invoice.getLastName().isEmpty() && !lastNameInput.getText().isEmpty()) {
            sendKeys(lastNameInput, invoice.getLastName());
        }

        if (!invoice.getCompany().isEmpty()) {
            sendKeys(companyInput, invoice.getCompany());
        }

        if (!invoice.getVatNumber().isEmpty()) {
            sendKeys(vatNumberInput, invoice.getVatNumber());
        }

        if (!invoice.getAddress().isEmpty()) {
            sendKeys(addressInput, invoice.getAddress());
        }

        if (!invoice.getAddressComplement().isEmpty()) {
            sendKeys(addressComplementInput, invoice.getAddressComplement());
        }

        if (!invoice.getPostcode().isEmpty()) {
            sendKeys(postCodeInput, invoice.getPostcode());
        }

        if (!invoice.getCity().isEmpty()) {
            sendKeys(cityInput, invoice.getCity());
        }

        if (!invoice.getPhone().isEmpty()) {
            sendKeys(phoneInput, invoice.getPhone());
        }
        return this;
    }

    public void addNewInvoiceAddress(Invoice invoice) {
        click(addNewAddressLink);
        fillInvoiceForm(invoice);
        setInvoiceAddress();
        saveNewInvoiceAddress();
    }

    public CheckoutAddressPage addInvoiceAddress(Invoice invoice) {
        if (!isDisplayed(invoiceForm)) {
            addNewInvoiceAddress(invoice);
            confirmNewAddress();
        } else if (isDisplayed(invoiceForm)) {
            fillInvoiceForm(invoice);
            confirmAddress();
        }
        return this;
    }
}