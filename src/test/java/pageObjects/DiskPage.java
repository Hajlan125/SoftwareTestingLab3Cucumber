package pageObjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiskPage {
    File file;
    public DiskPage() {
        Configuration.downloadsFolder = "build/downloads";

    }

    @Step("Скачивание файла")
    public void downloadFile(){
        $(By.xpath("html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/span[1]"))
                .shouldHave(text("lab5_1.xls")).click();
        try {
            File excelFile = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]"))
                    .download();
            sleep(15000);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sleep(1000);
    }

    @Step("Проверка файла")
    public void checkFile(){
        file = searchFileByDeepness("/Users/adelgaraev/Desktop/ТестПО/Lab2Selenide",
                "lab5_1.xls");

        XLS xls = new XLS(file);

        assertThat(xls, XLS.containsText("Москва"));
        assertThat(xls, XLS.containsText("Название"));
        sleep(1000);
    }

    @Step("Выгрузка файла")
    public void uploadFile() {
        refresh();
        File imgFile = new File("z-toxic.jpg");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/span[2]/div[1]/input[1]"))
                .uploadFile(imgFile);

    }

    @Step("Удаление файла с диска")
    public void deleteFile() {
        refresh();
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]"))
                .shouldHave(text("z-toxic.jpg")).contextClick();
        $(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[4]/div[2]")).shouldHave(text("Удалить"))
                .click();
        sleep(5000);
    }
    public static File searchFileByDeepness(final String directoryName, final String fileName) {
        File target = null;
        if(directoryName != null && fileName != null) {
            File directory = new File(directoryName);
            if(directory.isDirectory()) {
                File file = new File(directoryName, fileName);
                if(file.isFile()) {
                    target = file;
                }
                else {
                    List<File> subDirectories = getSubDirectories(directory);
                    do {
                        List<File> subSubDirectories = new ArrayList<File>();
                        for(File subDirectory : subDirectories) {
                            File fileInSubDirectory = new File(subDirectory, fileName);
                            if(fileInSubDirectory.isFile()) {
                                return fileInSubDirectory;
                            }
                            subSubDirectories.addAll(getSubDirectories(subDirectory));
                        }
                        subDirectories = subSubDirectories;
                    } while(subDirectories != null && ! subDirectories.isEmpty());
                }
            }
        }


        return target;
    }

    private static List<File> getSubDirectories(final File directory) {
        File[] subDirectories = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File current, final String name) {
                return new File(current, name).isDirectory();
            }
        });
        return Arrays.asList(subDirectories);
    }
}
