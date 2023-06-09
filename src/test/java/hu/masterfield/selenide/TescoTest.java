package hu.masterfield.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hu.masterfield.selenide.pages.AccountHomePage;
import hu.masterfield.selenide.pages.LoginPage;
import hu.masterfield.selenide.pages.ProductsPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Screenshots.saveScreenshotAndPageSource;
import static com.codeborne.selenide.Selenide.back;

public class TescoTest extends BaseTest {
    @Test
    @DisplayName("Tesco login test")
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.acceptCookies(); // összes cookie elfogadása előbb
        loginPage.clickLogin();
        loginPage.validateTitle();
        loginPage.validateUI();
        AccountHomePage accountHomePage = loginPage.login();
        accountHomePage.validate();

        // ProductsPage helyett AccountHomePage
        // ProductsPage productsPage = loginPage.login();
        // productsPage.validateURL();
        // productsPage.changeSortOrder();
    }
}
