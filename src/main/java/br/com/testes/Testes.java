package br.com.testes;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Testes extends ChromeTest {

    @DisplayName("Primeiro Teste")
    @Test
    void test() {
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        Assertions.assertEquals("Hands-On Selenium WebDriver with Java",title);
    }

}
