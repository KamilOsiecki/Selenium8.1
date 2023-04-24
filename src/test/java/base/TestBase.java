package base;

import configuration.AppProperties;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import providers.DriverFactory;
import providers.InvoiceFactory;
import providers.UserFactory;
import tests.steps.UserSteps;

@Slf4j
public class TestBase {
    protected static WebDriver driver;
    private static DriverFactory driverFactory;
    private static AppProperties appProperties;
    protected static UserSteps userSteps;
    protected static UserFactory userFactory;
    protected static InvoiceFactory invoiceFactory;


    @BeforeAll
    static void setup() {
        appProperties = AppProperties.getInstance();
        driverFactory = new DriverFactory();
        userSteps = new UserSteps();
        userFactory = new UserFactory();
        invoiceFactory = new InvoiceFactory();
    }

    @BeforeEach
    void setupDriver() {
        driver = driverFactory.getDriver();
        driver.get(System.getProperty("app_url"));
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            log.info("WebDriver closed successfully");
        } catch (Exception e) {
            log.error("WebDriver was not closed.");
        }
    }

    @SneakyThrows
    public <T extends BasePage> T at(Class<T> pageType) {
        return pageType.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }
}