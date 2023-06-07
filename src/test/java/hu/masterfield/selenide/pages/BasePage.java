package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    public void isLoaded(SelenideElement element) {
        element.shouldBe(visible);
    }

    // true - element is clickable and enabled
    public void isInteractable(SelenideElement element) {
        element.shouldBe(enabled);
    }

    // get actual URL
    public String getURL() {
        return url();
    }
}
