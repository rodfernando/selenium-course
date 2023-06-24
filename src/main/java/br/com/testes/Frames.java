package br.com.testes;

import br.com.utils.ChromeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        //How to know how many iframes do I have in my application?
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // Frame is a component which is hosted on the webpages; specific container.
        driver.switchTo().frame(0);
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));//"iframe.demo-frame"
        driver.findElement(By.id("draggable")).click();

        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();

        driver.switchTo().defaultContent();

    }

}
