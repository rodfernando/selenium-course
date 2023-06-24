package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class NestedFrame extends ChromeTest {

    @Test
    void nestedFrame() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

        System.out.println(driver.findElements(By.tagName("frame")).size());

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

    }
}
