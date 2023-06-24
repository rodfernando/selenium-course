package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class Scope extends ChromeTest {

    @Test
    void scope() throws InterruptedException {
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //give me the count of links on the page:
        System.out.println("Quantidades de links no site: " + driver.findElements(By.tagName("a")).size());

        System.out.println("Quantidade de links no rodapé do site: " + driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
        // or
        WebElement footDriver = driver.findElement(By.id("gf-BIG")); // defining scope
        System.out.println("Quantidade de links no rodapé do site: " + footDriver.findElements(By.tagName("a")).size());

        // Taking the first footer's column links using limited scope:
        WebElement columnDriver = footDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("First Column links counts: " + columnDriver.findElements(By.tagName("a")).size());

        // Click on each link and check if the pages are opening:
        for (int i = 1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL, Keys.ENTER); // instead of clicking, it sends the CTRL + t keys
        }  // Opening all the tabs:

        //
        Set<String> countWindow = driver.getWindowHandles(); // There are 4 windows
        Iterator<String> it = countWindow.iterator(); // This object will iterate between this 4 windows; it'll move in between each window
        while (it.hasNext()){ // hasNext tells us whether the tab is present or not
            driver.switchTo().window(it.next());// it begins in the first index and move to the next index
            System.out.println(driver.getTitle());
        } //Getting all tabs titles
    }
}