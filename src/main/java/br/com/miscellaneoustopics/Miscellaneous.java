package br.com.miscellaneoustopics;

import br.com.utils.ChromeTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Miscellaneous extends ChromeTest {

    @Test
    @DisplayName("Como tirar Screenshot")
    void miscellaneous() throws IOException {

        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("sessionkey");

        driver.get("https://www.blizzard.com/pt-br");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Estudos\\Estudos atualizados\\SeleniumCourse\\scr.png"));

    }
}
