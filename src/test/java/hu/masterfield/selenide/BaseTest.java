package hu.masterfield.selenide;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setip() {
        Configuration.reportsFolder = "target/reports";
        // Configuration. milyen browsert indítson el stb...
    }
}
