package br.com.seleniumfeatures;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.*; //tem que importar manualmente

public class LocatorsFeatures extends ChromeTest {

    @Test
    void filtrosRelativos() {

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEdit = driver.findElement(By.cssSelector("[name*='name']"));

        String label = driver.findElement(with(By.tagName("label")).above(nameEdit)).getText();
        System.out.println(label);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();

        WebElement inlineRadio1 = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(inlineRadio1)).getText());
    }
}
