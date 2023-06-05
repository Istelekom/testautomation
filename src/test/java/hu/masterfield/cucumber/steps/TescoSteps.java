package hu.masterfield.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class TescoSteps {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @Before
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TescoSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);
        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }


    @After
    public static void cleanup() {
        driver.quit();
    }

    @Given("open main page")
    public void openMainPage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU/");
    }

    /*
    @And("accept cookies")
    public void acceptCookies() {

        // xpath text //*[@id="sticky-bar-cookie-wrapper"]/span/div/div/div[2]/form[1]/button/span/span
        // full xpath button /html/body/div[1]/div/div/div[1]/div/span/div/div/div[2]/form[1]/button
        WebElement acceptButton = wait.until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/span/div/div/div[2]/form[1]/button")));
        acceptButton.click();
    }
    */

    @And("language is set to {string}")
    public void languageIsSetTo(String lang /* Magyar */) {

        WebElement languetable = wait.until(driver -> driver.findElement(By.id("languagetable")));

        if (lang.equals("Magyar")) {
            driver.findElement(By.cssSelector("#languagetable > span:nth-child(1)")).click(); // a span 1. gyereke
        }
        if (lang.equals("English")) {
            driver.findElement(By.cssSelector("#languagetable > span:nth-child(2)")).click(); // második gyerek
        }
    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String newLang) {
        languageIsSetTo(newLang); // meghívom a már elkészített függvényt (ne legyen kódismétlés)
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        WebElement titleH2 = wait.until(driver -> driver.findElement(By.cssSelector("#utility-header-help-link > span"))); // copy selector volt az oldalon
        if (lang.equals("Magyar")) {
            assertEquals("Segítség", titleH2.getText()); // org.junit -ból importálni
        }
        if (lang.equals("English")) {
            assertEquals("Help", titleH2.getText()); // org.junit -ból importálni
        }
    }

    @When("change the language to")
    public void changeTheLanguageTo(DataTable dataTable) { //io.cucumber.DataTable
        for (Map<String, String> cells : dataTable.entries()) {
            changeTheLanguageTo(cells.get("lang"));
            System.out.println(cells.get("code"));
        }
    }
}
