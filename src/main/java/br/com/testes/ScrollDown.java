package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScrollDown extends ChromeTest {
    @Test
    void scrollDown() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver; // driver executará o javascript

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // digitar window.scrollBy(0,500) no console do site irá deslizar o scrollbar do site
        // para achar o scrollbar da tabela, basta digitar no console 'document.querySelector(".tableFixHead")' -> class=tableFixHead

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        /*Para uma única tabela:
         * xpath -> //td[4] ou //div[@class='tableFixHead']/table/tbody/tr/td[4]
         * cssSelector -> td:nth-child(4) ou .tableFixHead td:nth-child(4)
         *  */


        List<WebElement> values =  driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        //prestar atenção na hora de criar a lista com webelementos de colocar findElementS

        //Somatório de cada número da tabela
        int sum = 0;

        for (WebElement value : values) {

            sum += Integer.parseInt(value.getText());
        }
        System.out.println("A soma foi de " + sum);


        /*Para pegar o número 296, usa-se a expressão pegando o texto que deseja. Em seguida, coloca a linha para debugar
        * Em seguida, pegamos a expressão e jogamos no watcher, tendo o resultado sem precisar ficar rodando o código e vendo como fica*/
        int result = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());

        assertEquals(sum, result);
    }

}
