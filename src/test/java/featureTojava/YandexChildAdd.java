package featureTojava;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexChildAdd {
    WebDriver driver;
//    public YandexChildAdd(WebDriver driver){
//        this.driver = driver;
//    }

    @Given("an open browser with Yandex profile page")
    public void checkUrl() {
//        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), ConfProperties.getProperty("profile_page"));

    }
    @When("user press \"Семья\" page button")
    public void familyButton() {
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/aside/nav/ul/li[4]/a")).click();
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/aside/nav/ul/li[4]/a")).click();
    }
    @And("user press \"Добавить профиль\" button")
    public void refreshPage() {
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div[3]/div/div/div/div[2]/div/button")).click();
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div[3]/div/div/div/div[2]/div/button")).click();
    }

    @And("user press \"Добавить профиль\" button again")
    public void upload() {
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div[2]/div/div/button")).click();
        $(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div[2]/div/div/button")).click();
    }


    @And("user insert name of child and press continue button")
    public void childNameInsert() {
//        driver.findElement(By.id("passp-field-displayName")).sendKeys(ConfProperties.getProperty("child_name"));
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div")).click();
        $(By.id("passp-field-displayName")).sendKeys(ConfProperties.getProperty("child_name"));
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div")).click();
    }

    @And("user press \"6+\" button and continue button")
    public void delet() {
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div/button")).click();
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/div[1]/div[2]")).click();
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div/button")).click();
    }
    @And("user choose child's gender and his birthday and press \"Создать профиль\" button")
    public void createProfile() {
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[2]/span/label[2]/input")).click();
//        driver.findElement(By.xpath("//*[@id=\"kiddish-birthday-day\"]")).sendKeys(ConfProperties.getProperty("child_day"));
//        Select select = new Select(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[2]/span[2]/select")));
//        select.selectByValue("5");
//        driver.findElement(By.xpath("//*[@id=\"kiddish-birthday-year\"]")).sendKeys(ConfProperties.getProperty("child_year"));
//        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div")).click();
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[2]/span/label[2]/input")).click();
        $(By.xpath("//*[@id=\"kiddish-birthday-day\"]")).sendKeys(ConfProperties.getProperty("child_day"));
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[2]/span[2]/select")).selectOptionByValue("5");
        $(By.xpath("//*[@id=\"kiddish-birthday-year\"]")).sendKeys(ConfProperties.getProperty("child_year"));
        $(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/div/div[3]/div")).click();
    }

    @Then("user finds himself on Yandex disk page")
    public void nit() {

    }
}
