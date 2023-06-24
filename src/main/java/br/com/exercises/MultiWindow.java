package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultiWindow extends ChromeTest {

    @Test
    void multiWindow(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();

        driver.switchTo().window(it.next());
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.cssSelector("div[id='content'] div h3")).getText());

    }
}
