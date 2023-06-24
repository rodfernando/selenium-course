package br.com.seleniumfeatures;

import br.com.utils.ChromeTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiWindow extends ChromeTest {

    @Test
    void multiTab() throws InterruptedException, IOException {

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB); //vai criar uma tab nova

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        //Pegando o link do elemento
        List<WebElement> cursos = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));

        List<String> cursoJava = cursos.stream()
                .filter(i->i.getText().contains("Core Java"))
                .map(WebElement::getText)
//                .findFirst()
                .toList();
        Thread.sleep(3000);
//        cursoJava.forEach(System.out::println);
        String cursoPesquisado = cursoJava.get(0);

        //Voltando para a página
        driver.switchTo().window(parentWindowId);
        WebElement nameCamp = driver.findElement(By.cssSelector("[name='name']"));
        nameCamp.sendKeys(cursoPesquisado);

        // Pegando screenshot a partir de um webelement
        File file = nameCamp.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("logo.png"));

        //Pegando height e width
        System.out.println(nameCamp.getRect().getDimension());
        System.out.println(nameCamp.getRect().getHeight());
        System.out.println(nameCamp.getRect().getWidth());
        System.out.println(nameCamp.getRect().getPoint());

    }
}
