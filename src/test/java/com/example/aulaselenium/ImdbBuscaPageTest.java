package com.example.aulaselenium;

import com.example.aulaselenium.pages.BasicPage;
import com.example.aulaselenium.pages.ImdbPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImdbBuscaPageTest {

    @Test
    public void testeBusca() {
        System.setProperty("webdriver.chrome.driver", "D:\\temp\\aula-selenium\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        ChromeDriver chrome = new ChromeDriver(chromeOptions);

        ImdbPage page = new ImdbPage(chrome);

        String title = chrome.getTitle();
        String expected = "IMDb: Classificações, avaliações e onde assistir os melhores filmes e séries";
        Assertions.assertEquals(expected, title);

//        WebElement barraDePesquisa = driver.findElement(By.id("suggestion-search"));
//        barraDePesquisa.click();
//        barraDePesquisa.sendKeys("Breaking bad");

        page.pesquisarPor("breaking bad");
        Assertions.assertEquals(chrome.findElement(By.tagName("h1")).getText(),"Pesquisar \"breaking bad”");
    }

    @Test
    public void testeBusca2() {
        System.setProperty("webdriver.chrome.driver", "D:\\temp\\aula-selenium\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        ChromeDriver chrome = new ChromeDriver(chromeOptions);
        chrome.get("https://www.imdb.com/");

        String textoPesquisado = "";

        WebElement barraDePesquisa = chrome.findElement(By.id("suggestion-search"));
        barraDePesquisa.click();
        barraDePesquisa.sendKeys(textoPesquisado);

        WebElement botaoPesquisar = chrome.findElement(By.id("iconContext-magnify"));
        botaoPesquisar.click();

        ExpectedCondition condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().toLowerCase().startsWith(textoPesquisado.toLowerCase());
            }
        };

        new WebDriverWait(chrome, Duration.ofMillis(500)).until(condition);
    }
}