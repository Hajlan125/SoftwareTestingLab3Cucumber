import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.logevents.SelenideLogger;

import featureTojava.YandexAuthorization;
import featureTojava.YandexChildAdd;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Y;
import io.cucumber.java.ast.Ya;
import io.cucumber.junit.Cucumber;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
public class MainTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //Configuration.headless = true;
        try {
            FileUtils.deleteDirectory(new File("allure-results"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true).includeSelenideSteps(true));
//        System.setProperty("webdriver.chrome.driver", "chromedriver-2");
//        driver = new ChromeDriver();
//
//        YandexAuthorization yandexAuthorization = new YandexAuthorization(driver);
//        YandexChildAdd yandexChildAdd = new YandexChildAdd(driver);

        Configuration.startMaximized = true;

    }
}
