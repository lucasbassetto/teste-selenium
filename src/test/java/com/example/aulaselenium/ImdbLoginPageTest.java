package com.example.aulaselenium;

import com.example.aulaselenium.pages.ImdbLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImdbLoginPageTest {
    ChromeDriver chrome;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\temp\\aula-selenium\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        chrome = new ChromeDriver(chromeOptions);
    }

    @Test
    public void testeLoginFalha(){

        ImdbLoginPage page = new ImdbLoginPage(chrome);
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofMillis(10000));

//         presenceOfElementLocated condition
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ap_email\"]")));

        //dados incorretos, só pra não divulgar dados pessoais
        page.enterEmail("naruto123212@gmail.com");
        page.enterPassword("88273281");
        page.getButtonLogin();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"auth-warning-message-box\"]/div")));
        String resultado = chrome.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div")).getText();
        String esperado = "Important Message!\n" +
                "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";

        Assertions.assertEquals(esperado, resultado);
    }

}
