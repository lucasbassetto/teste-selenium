package com.example.aulaselenium.pages;

import org.openqa.selenium.WebDriver;

public class BasicPage {

    private WebDriver driver;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitulo() {
        return driver.getTitle();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
