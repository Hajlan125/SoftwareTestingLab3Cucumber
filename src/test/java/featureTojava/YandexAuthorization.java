package featureTojava;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class YandexAuthorization {

    @Given("an open browser with Yandex ru auth")
    public void operUrl() {

        open("https://passport.yandex.ru/auth");
    }
    @When("user type login and press enter")
    public void loginType() {
        $(By.id("passp-field-login")).val("AdRGaraev").pressEnter();
    }

    @And("user type password and press enter")
    public void passwordType() {
        $(By.id("passp-field-passwd")).val("zut47wt8").pressEnter();
    }

    @Then("user should see profile page")
    public void profilePage() {
        $(By.className("personal-info-login")).shouldHave(text("AdRGaraev"));
        given().baseUri("https://api.passport.yandex.ru")
                .when().get("/all_accounts")
                .then().statusCode(200)
                .extract().jsonPath();
    }
}
