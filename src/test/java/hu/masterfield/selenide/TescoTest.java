package hu.masterfield.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
        loginPage.validateTitle();
        loginPage.validateUI();
        ProductsPage productsPage = loginPage.login();
        productsPage.validateURL();
        //productsPage.changeSortOrder();

        // productsPage.getProductLinks(); ezt introduce local variable (Alt+Enter)
        // ez lett belőle:
        /*
        ElementsCollection productLinks = productsPage.getProductLinks();



        // Click on all links containing "Labs
        ElementsCollection filteredProductLinks = productLinks.filterBy(matchText("Labs"));
        for (int idx = 0; idx < filteredProductLinks.size(); idx++) {
            ElementsCollection links = productLinks.filterBy(matchText("Labs"));

            productsPage.changeSortOrder(); // Berka Tomi javasolta

            SelenideElement link = links.get(idx);
            link.shouldBe(visible);
            link.click();

            //takeScreenshot("screenshot" + idx);
            saveScreenshotAndPageSource();
            // a target mappa reports almappájában-ban lesznek

            Thread.sleep(2000);
            back();
        }
        */
    }
}
