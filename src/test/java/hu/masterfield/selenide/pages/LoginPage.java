package hu.masterfield.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    //WebElement userNameInput;
    SelenideElement userNameInput = $(byId("user-name"));

    //WebElement passwordInput;
    SelenideElement passwordInput = $(byId("password"));

    //WebElement loginButton;
    SelenideElement loginButton = $(byId("login-button"));

    public void openPage() {
        open("https://bevasarlas.tesco.hu/groceries/hu-HU/"); //ugyanaz mint a: Selenide.open() (így olvashatóbb, nem kell minidg elé írni a Selenide-t)
        isLoaded(loginButton);
    }

    public void validateUI() {
        userNameInput.shouldBe(visible).shouldBe(enabled);  // Condition.visible volt
        passwordInput.shouldBe(visible).shouldBe(enabled);
        loginButton.shouldBe(visible).shouldBe(enabled);
    }

    public void validateTitle(){
        assertEquals("Swag Labs", title()); //Selenide.title()
    }

    public ProductsPage login(){
        userNameInput.setValue("standard_user");
        // userNameInput.sendKeys("standard_user");
        // DE sendKeys-et átírjuk setValue-re mert ez törli, beállítja, többet csinál
        passwordInput.setValue("secret_sauce");
        loginButton.click();
        return new ProductsPage();
    }
}
