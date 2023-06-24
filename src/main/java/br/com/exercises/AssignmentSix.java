package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssignmentSix extends ChromeTest {

    @Test
    void practicePage() {
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

        // Instacing a webelement:
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        // Calling Select class for make actions, receiving the webelement
        Select s = new Select(dropdown);
        s.selectByVisibleText(opt);

        driver.findElement(By.name("enter-name")).sendKeys(opt);

        driver.findElement(By.id("alertbtn")).click();

        //Switching to notification window
        String text=  driver.switchTo().alert().getText();

        if(text.contains(opt))

        {

            System.out.println("Alert message success");

        }

        else

            System.out.println("Something wrong with execution");

    }

    //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());
}

