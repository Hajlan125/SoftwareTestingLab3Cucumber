package featureTojava;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexAuthorization {
    public WebDriver driver;
//    public YandexAuthorization(WebDriver driver){
//        this.driver = driver;
//    }
    @Given("an open browser with Yandex ru auth")
    public void operUrl() {
        open(ConfProperties.getProperty("login_page"));
    }
    @When("user type login and press enter")
    public void loginType() {
//        driver.findElement(By.id("passp-field-login")).sendKeys(ConfProperties.getProperty("login"));
//        driver.findElement(By.id("passp-field-login")).sendKeys(Keys.ENTER);
        $(By.id("passp-field-login")).val(ConfProperties.getProperty("login")).pressEnter();
    }

    @And("user type password and press enter")
    public void passwordType() {
//        driver.findElement(By.id("passp-field-passwd")).sendKeys(ConfProperties.getProperty("password"));
//        driver.findElement(By.id("passp-field-passwd")).sendKeys(Keys.ENTER);
        $(By.id("passp-field-passwd")).val(ConfProperties.getProperty("password")).pressEnter();
    }

    @Then("user should see profile page")
    public void profilePage() {
//        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), ConfProperties.getProperty("profile_page"));
    }
}
