package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountHomePage extends BasePage {
    // SelenideElement-ek ....

    SelenideElement greetingMessage = $(byXpath("/html/body/div[1]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[2]/h1/span[1]"));

    SelenideElement greetingName = $(byXpath("/html/body/div[1]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[2]/h1/span[2]"));

    public void validate() {
        /* "Üdvözlünk Pisti" szoveg ellenorzese */
        greetingMessage.shouldHave(visible).shouldHave(text("Üdvözlünk"));
        greetingName.shouldHave(visible).shouldHave(text("Pisti"));
    }
}
