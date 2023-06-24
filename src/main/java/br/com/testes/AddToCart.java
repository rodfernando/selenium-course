package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddToCart extends ChromeTest {

    @Test
    @DisplayName("Adicionando uma lista de frutas no carrinho")
    void addToCart() throws InterruptedException {
        // Declaring array of Strings:
        String[] itemsNeeded = {"Cucumber","Brocolli", "Beetroot", "Carrot"};

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Explict wait: é dado o tempo para um elemento específico:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Implicit wait: o tempo é dado para o caso de teste de modo geral

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;

        for (int i = 0; i < products.size(); i++) {
            // Brocolli - 1 Kg --> Brocolli = [0], 1 Kg = [1]
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim(); // trim remove os espaços

            // check whether name you extracted is present in arrayList or not
            // convert array into arrayList for easy search:
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName)) {
                j++;
                // Click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //parent - child
                if(j==itemsNeeded.length){ //we use length() method to get Size of Array and we use size() method to get size of Arraylist
                    break;
                }
            }

        }

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }


}
