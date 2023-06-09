package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    //WebElement userNameInput;
    SelenideElement emailInput = $(byId("email"));

    //WebElement passwordInput;
    SelenideElement passwordInput = $(byId("password"));

    //WebElement loginButton;
    //SelenideElement loginButton = $(byXpath("/html/body/div[1]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/a"));
    // ennél elhasal... Element not found By.xpath: ... NoSuchElementException
    //SelenideElement loginButton = $(byXpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/section/div/form/div/button/span"));
    //ez még rosszabb, el se jut a Bejelentkezés oldalra
    SelenideElement loginButton = $(byClassName("button-primary")); // ezzel végre működött!!!

    //SelenideElement acceptButton = $(byXpath("/html/body/div[1]/div/div/div[1]/div/span/div/div/div[2]/form[1]/button"));
    //SelenideElement acceptButton = $(byXpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span"));
    SelenideElement acceptButton = $(byClassName("beans-button__container")); // nem hiszem el, de ezzel működik ez is, xpath-szal sehogyse

    public void openPage() {
        open("https://bevasarlas.tesco.hu/groceries/hu-HU/"); //ugyanaz mint a: Selenide.open() (így olvashatóbb, nem kell minidg elé írni a Selenide-t)
        isLoaded(loginButton);
        loginButton.click(); // rá kellene kattintani ???
    }

    public void acceptCookies() {
        // acceptButton = wait.until(driver -> driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/span/div/div/div[2]/form[1]/button")));
        isLoaded(acceptButton);
        acceptButton.click();
    }

    public void validateUI() {
        emailInput.shouldBe(visible).shouldBe(enabled);  // Condition.visible volt
        passwordInput.shouldBe(visible).shouldBe(enabled);
        loginButton.shouldBe(visible).shouldBe(enabled);
    }

    public void validateTitle(){
        assertEquals("Bejelentkezés - Tesco Online, Tesco Otthonról", title()); //Selenide.title()
    }

    public AccountHomePage login(){
        emailInput.setValue("proba1@email.hu");
        // userNameInput.sendKeys("standard_user");
        // DE sendKeys-et átírjuk setValue-re mert ez törli, beállítja, többet csinál
        passwordInput.setValue("ProbaJelszo123");
        loginButton.click();
        return new AccountHomePage();
    }
}
