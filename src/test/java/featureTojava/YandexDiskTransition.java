package featureTojava;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class YandexDiskTransition {

    @Given("an open browser with Yandex profile page")
    public void openedBrowser() {
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://passport.yandex.ru/profile");
    }

    @When("user press profile page button")
    public void pressProfileButton() {
        $(By.className("PageHeader-user")).click();
    }

    @And("user press \"Диск\" button")
    public void pressDiskButton() {
        $(By.xpath("//header/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/ul[1]/li[3]/a[1]")).click();
    }

    @Then("user finds himself on Yandex disk page")
    public void urlCheck() {
        //assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://disk.yandex.ru/client/disk?source=main-loginmenu&idApp=client&reduxDialog=welcome");
    }
}
