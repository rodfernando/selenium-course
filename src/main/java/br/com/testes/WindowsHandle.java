package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandle extends ChromeTest {

    @Test
    void windowHandle(){
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();

        //Dizendo para o selenium qual aba vc está:
        Set<String> windows = driver.getWindowHandles(); // parentid 0 --> childid 1 --> subschildId 2
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        // Para outras abas
        // String subChildId = it.next();
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        // Para ajudar a pegar o texto, pode ser utilizado o Debug e colocar a expressão em análise.
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId);
    }



}
