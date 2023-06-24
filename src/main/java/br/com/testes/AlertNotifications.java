package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AlertNotifications extends ChromeTest {

    @Test
    @DisplayName("Alert Notification")
    void alertNotification() {
        String text = "Rodrigo";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        // para aceitar o alerta aberto:
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
}
