import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
public class MainTest {

    static DiskPage diskPage;

    @BeforeClass
    public static void setUp() {

        try {
            FileUtils.deleteDirectory(new File("allure-results"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Configuration.proxyEnabled = true;
        Configuration.fileDownload = FileDownloadMode.PROXY;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true).includeSelenideSteps(true));
        //System.setProperty("webdriver.chrome.driver", "chromedriver");

        Configuration.startMaximized = true;

    }
}
