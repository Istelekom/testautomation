package hu.masterfield.selenide;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        Configuration.reportsFolder = "target/reports";
        // Configuration. milyen browsert indítson el stb...

        // ide kellett az alábbi kód, hogy ne legyen Access denied
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        Configuration.browserCapabilities = options; // ebben van a lényeg
    }
}
