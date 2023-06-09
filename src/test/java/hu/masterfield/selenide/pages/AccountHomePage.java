package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountHomePage extends BasePage {
    /* SelenideElement ....
     *  */

    // Üdvözlünk
    //Pisti

    SelenideElement greetingMessage = $(byValue("Üdvözlünk"));

    SelenideElement greetingName = $(byValue("Pisti"));

    public void validate() {
        /* "Üdvözlünk Pisti" szoveg ellenorzese */
        greetingMessage.shouldBe(visible).shouldBe(enabled);
        greetingName.shouldBe(visible).shouldBe(enabled);
    }
}
