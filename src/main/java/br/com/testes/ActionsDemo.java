package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo extends ChromeTest {

    @Test
    @DisplayName("Exemplos de interações com o mouse")
    void actionsDemo() {
        driver.get("https://www.amazon.com.br/");

        // Criação de ações:
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));

        //Move para um elemento específico:
        actions.moveToElement(move).contextClick().build().perform(); // tem que escrever os métodos build e perform

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")));

        actions.moveToElement(
                driver.findElement(
                        By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.LEFT_SHIFT).sendKeys("hello").doubleClick().build().perform();
    }

}
