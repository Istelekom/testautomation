package hu.masterfield.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsPage extends BasePage {

    //@FindBy(className = "product_sort_container")
    //WebElement sortDDLSelect;
    SelenideElement sortDDLSelect = $(byClassName("product_sort_container"));

    //@FindBy(className = "inventory_item_name")
    //WebElement firstLinkDiv;
    SelenideElement firstLinkDiv = $(byClassName("inventory_item_name"));



    public void validateURL() {

        assertEquals("https://bevasarlas.tesco.hu/groceries/hu-HU/shop/pekaru/all", url());
    }

    public void changeSortOrder(){
        // Select sortDDL = new Select(sortDDLSelect);
        // sortDDL.selectByValue("za");
        sortDDLSelect.selectOptionByValue("za");
        // assertEquals("Test.allTheThings() T-Shirt (Red)", firstLinkDiv.getText());
        firstLinkDiv.shouldBe(visible).shouldHave(exactText("Test.allTheThings() T-Shirt (Red)"));
    }

    public ElementsCollection getProductLinks() {
        ElementsCollection productLinks = $$(byTagName("a")); // <a></a> tag
        productLinks.shouldHave(size(20));
        return productLinks; // amíg ez a sor nem volt, addig a következő kapcsos zárójel után piros volt
    }
}
