package featureTojava;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import pageObjects.DiskPage;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexDiskDownloadUpload {

    DiskPage diskPage;

    @Given("opened browser with Yandex disk page")
    public void checkUrl() {
        //assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://disk.yandex.ru/client/disk?source=main-loginmenu&idApp=client&reduxDialog=welcome");
    }
    @When("user press on file and press download")
    public void download() {
        diskPage = new DiskPage();
        diskPage.downloadFile();
    }
    @And("user refresh page")
    public void refreshPage() {
        refresh();
    }
    @And("user upload file")
    public void upload() {
        diskPage.uploadFile();
    }
    @And("user delete uploaded file")
    public void delet() {
        diskPage.deleteFile();
        try {
            FileUtils.deleteDirectory(new File("build/downloads"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        close();
    }
}
