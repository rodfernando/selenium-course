package br.com.exercises;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends ChromeTest {

    @Test
    @DisplayName("Login Page Practise")
    void loginPage() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span.checkmark")).click();
//        driver.switchTo().alert().accept();

        // Selecionando uma opção numa lista:
        WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(2);
        // dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='signin']")));
        driver.findElement(By.cssSelector("input[name='signin']")).click();
        // Caso seja necessário pegar o texto do item
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //----------------------------------------------------------------------//
        //Definindo array de nomes a serem pesquisados:
        String[] devices = {"iphone", "samsung", "nokia", "blackberry"};
        //Definindo arrayList que receberá os elementos web
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
        List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));

        int count = 0; //
        for (int i = 0; i < products.size(); i++) {
            // Tratamento do texto extraído de cada elemento:
            String[] name = products.get(i).getText().toLowerCase().split(" ");
            String formattedName = name[0].trim();

            // Variável que recebe o array e transforma em arraylist para poder utilizar métodos arrayList
            List devicesList = Arrays.asList(devices);

            if(devicesList.contains(formattedName)) {
                count++;
                driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
                if(count== devices.length){
                    break;
                }
            }
        }

        // ação de clicar no botão checkout:
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='country']")).sendKeys("Rua José Nunes da Cunha, Candeias");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class=\"btn btn-success btn-lg\"]")).click();


        String[] finalPhrase = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText().split("\n");
        String formattedFinalName = finalPhrase[1].trim();

        System.out.println(formattedFinalName);
    }
}
