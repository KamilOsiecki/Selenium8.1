package providers;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

@Slf4j
public class DriverFactory {
    private WebDriver driver;
    private Browsers browsers;

    public WebDriver getDriver() {
        this.browsers = Browsers.valueOf(getByUpperCaseName(System.getProperty("browser_name")));
        switch (browsers) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            case EDGE -> getEdgeDriver();
            case IE -> getIeDriver();
        }
        return this.driver;
    }

    private void getChromeDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        optionsChrome.addArguments("start-maximized");
        optionsChrome.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(optionsChrome);
        getDriverInformation(Browsers.CHROME);
    }

    private void getFirefoxDriver() {
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        optionsFirefox.addArguments("start-maximized");
        driver = new FirefoxDriver(optionsFirefox);
        getDriverInformation(Browsers.FIREFOX);
    }

    private void getEdgeDriver() {
        EdgeOptions optionsEdge = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        optionsEdge.addArguments("start-maximized");
        driver = new EdgeDriver(optionsEdge);
        getDriverInformation(Browsers.EDGE);
    }

    private void getIeDriver() {
        InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(optionsDefault);
        getDriverInformation(Browsers.IE);
    }

    private void getDriverInformation(Browsers browsers) {
        log.info(browsers + " Webdriver was initialized.");
    }

    private static String getByUpperCaseName(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            return null;
        }
        return browserName.toUpperCase();
    }
}