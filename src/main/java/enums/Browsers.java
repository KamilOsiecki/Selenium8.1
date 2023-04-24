package enums;

public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    IE("ie");
    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }
}