package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QaAcademy extends ChromeTest {

    @Test
    void ScrollDownAgain() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> colums = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));

        int quantity = 0;

        for (WebElement cell : colums) {
            quantity++;
        }
        System.out.println("Temos " + quantity + " coluna(s)");


        List<WebElement> lines = driver.findElements(By.xpath("//table[@id='product']/tbody/tr[3]/td"));

        System.out.println();

        for (int i = 0; i < colums.size(); i++) {
            System.out.println(lines.get(i).getText());
        }



//        driver.get("http://qaclickacademy.com/practice.php");
//
//        WebElement table=driver.findElement(By.id("product"));
//
//        System.out.println(table.findElements(By.tagName("tr")).size());
//
//        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//
//
//
//        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//
//
//
//        System.out.println(secondrow.get(0).getText());
//
//        System.out.println(secondrow.get(1).getText());
//
//        System.out.println(secondrow.get(2).getText());
//
//    }
    }
}
