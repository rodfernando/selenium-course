package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LiveDemo extends ChromeTest {

    @Test
    public void kart() {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr//th[1]")).click();

        List<WebElement> listOfVegetables = driver.findElements(By.xpath("//tr//td[1]"));

        List<String> originalList = listOfVegetables.stream().map(WebElement::getText).toList();

        List<String> sortedList = originalList.stream().sorted().toList();

        assertEquals(originalList, sortedList);
    }

    @Test
    public void vegetablePrice() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr//th[1]")).click();

        List<Object> price; // precisa ser declarado fora para o while detectar o price

        do {
            List<WebElement> elementList = driver.findElements(By.xpath("//tr//td[1]"));

            price = elementList.stream()
                    .filter(i -> i.getText().equals("fruit"))
                    .map(LiveDemo::getveggieprice)
                    .toList();
            price.forEach(System.out::println);

            try{
                if (price.size() < 1) { //se não houver elemento na página:

                    driver.findElement(By.cssSelector("[aria-label='Next']")).click();
                }
            } catch (Exception e) {

                System.out.println("Item não encontrado!");
                break;
            }

        } while (price.size() < 1);

    }

    private static Object getveggieprice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    @Test
    public void filter() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies = driver.findElements(By.xpath("'//tr//td[1]'")); //5 results

        List<WebElement> filteredList = veggies.stream().filter(i->i.getText().equals("Rice")).toList(); // 1 result

        assertEquals(veggies, filteredList);


    }
}







