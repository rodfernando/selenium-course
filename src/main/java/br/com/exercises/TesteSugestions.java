package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TesteSugestions extends ChromeTest {

    @Test
    void autoSuggestion() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Br");
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Brazil")){
                option.click();
                break;
            }
        }


    }

}