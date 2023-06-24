package br.com.utils;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    public static WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }

    // Alternative
//    @BeforeEach
//    void setup() {
//        driver = WebDriverManager.chromedriver().create();
//
//    }


}