package br.com.miscellaneoustopics;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks extends ChromeTest {

    @Test
    @DisplayName("Verificando Status code e links quebrados")
    void brokenLinks() throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Step 1 - Take all url's tied up with links
        //no console do devtools -> $('a[href*="soapui"]')

//        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("HEAD");
//        connection.connect();
//
//        int responseCode = connection.getResponseCode();
//        System.out.println(responseCode);

        //Step 2 -
        //no console do devtools -> $('li[class="gf-li"] a')

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();

        for (WebElement link : links){

            String url = link.getAttribute("href");

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode < 400, "The link called " + link.getText() + " is broken with code status " + responseCode);
            // o softAssert fará todas as iterações mesmo que seja encontrada uma falha, armazenando-as
        }

        softAssert.assertAll();
    }
}
