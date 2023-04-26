package com.example.aulaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbLoginPage extends BasicPage {

    public ImdbLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.imdb.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.imdb.com%2Fregistration%2Fap-signin-handler%2Fimdb_us&openid." +
                "identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid." +
                "assoc_handle=imdb_us&openid.mode=checkid_setup&siteState=eyJvcGVuaWQuYXNzb2NfaGFuZGxlIjoiaW1kYl91cyIsInJlZGlyZWN0VG8iOiJodHRwczovL3d3dy5pbWRiLmNvbS8_" +
                "cmVmXz1sb2dpbiJ9&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs." +
                "openid.net%2Fauth%2F2.0&tag=imdbtag_reg-20");
    }

    public WebElement getEmail() {
        return getDriver().findElement(By.xpath("//*[@id=\"ap_email\"]"));
    }
    public WebElement getPassword() {
        return getDriver().findElement(By.xpath("//*[@id=\"ap_password\"]"));
    }

    public WebElement getButtonLogin() {
        return getDriver().findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
    }

    public void login(String email, String password) {
        enterEmail(email);

        enterPassword(password);
    }

    public void enterEmail(String email){
        getEmail().sendKeys(email);
    }

    public void enterPassword(String pwd){
        getPassword().sendKeys(pwd);
        getButtonLogin().click();
    }
}
