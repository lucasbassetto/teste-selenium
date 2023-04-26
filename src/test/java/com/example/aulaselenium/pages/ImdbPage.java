package com.example.aulaselenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbPage extends BasicPage {

    public ImdbPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.imdb.com/");
    }

    public WebElement getCampoPesquisa() {
        return getDriver().findElement(By.id("suggestion-search"));
    }

    public void pesquisarPor(String texto) {
        WebElement campo = this.getCampoPesquisa();
        campo.click();
        campo.sendKeys(texto);

        WebElement botaoPesquisar = getDriver().findElement(By.id("iconContext-magnify"));
        botaoPesquisar.click();
    }

    public WebDriver getPage() {
        return getDriver();
    }
}
