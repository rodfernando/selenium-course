package br.com.plataforma;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.time.Duration;

public class Plataforma extends ChromeTest {

    @Test
    void test() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://portal-parceiros.hml-cld.brasilseg.com.br/simulador-agricola/cadastro");
//        driver.findElement(By.id("email")).sendKeys("fernandinha098@hotmail.com");
//        driver.findElement(By.id("password")).sendKeys("Rural2022...");
//        driver.findElement(By.cssSelector("button[data-testid='test-button']")).click();
//        driver.findElement(By.xpath("//button[text()='adicionar oferta']")).click();

//
//        // Step 1
//        driver.findElement(By.cssSelector("#nmCpfCnpj")).click();
//        driver.findElement(By.cssSelector("#nmCpfCnpj")).sendKeys("287.054.830-34");
//        driver.findElement(By.cssSelector("#nmNome")).sendKeys("Rodrigo");
//        driver.findElement(By.cssSelector("input[id='lsTelefone[0].raw']")).click();
//        driver.findElement(By.cssSelector("input[id='lsTelefone[0].raw']")).sendKeys("81999999999");
//        driver.findElement(By.cssSelector("input[id='lsEmail[0].nmEmail']")).click();
//        driver.findElement(By.cssSelector("input[id='lsEmail[0].nmEmail']")).sendKeys("fernandinha098@hotmail.com");
//        driver.findElement(By.cssSelector("input[class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//        // Step 2
//        driver.findElement(By.cssSelector("option[value='11310129']")).click();
//        driver.findElement(By.cssSelector("option[value='SP']")).click();
//        driver.findElement(By.cssSelector("option[value='2383']")).click();
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/div[2]/button[1]")).click();
//        driver.findElement(By.cssSelector(".sc-ksBlkl.fesbVw")).click();
//        driver.findElement(By.cssSelector(".sc-ksBlkl.gBmXSR")).click();
//        driver.switchTo()
//                .activeElement()
//                .sendKeys("C:\\KML\\Campos Novos Paulista, SP 65,3 ha (1).kml");
//        Thread.sleep(3000);


    }
}


