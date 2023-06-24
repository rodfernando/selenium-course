package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Calendar extends ChromeTest {

    @Test
    void calendar() throws InterruptedException {
        driver.get("https://www.path2usa.com/travel-companion/");

        // Scroll the Page

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollBy(0,800)");

        // Click on the Date field

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();

        WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));

        while(!month.getText().contains("August")) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
        }

        int count= driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

        for(int i=0;i<count;i++) {
            String text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
            if(text.equalsIgnoreCase("26")) {
                // driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();
                driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
                System.out.println(text);
                break;
            }
        }
        System.out.println(driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value"));
    }
}