package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    //WebElement userNameInput;
    SelenideElement emailInput = $(byId("email"));

    //WebElement passwordInput;
    SelenideElement passwordInput = $(byId("password"));

    //WebElement loginButton;
    SelenideElement loginButton = $(byXpath("/html/body/div[1]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/a"));
    // ennél elhasal... Element not found By.xpath: ... NoSuchElementException
    //SelenideElement loginButton = $(byXpath("//*[@id=\"content\"]/div/div[1]/div/div[1]/section/div/form/div/button/span"));
    //ez még rosszabb, el se jut a Bejelentkezés oldalra


    public void openPage() {
        open("https://bevasarlas.tesco.hu/groceries/hu-HU/"); //ugyanaz mint a: Selenide.open() (így olvashatóbb, nem kell minidg elé írni a Selenide-t)
        isLoaded(loginButton);
        loginButton.click(); // rá kkellene kattintani ???
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
