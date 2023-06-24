package br.com.miscellaneoustopics;

import br.com.utils.ChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SSLCheck extends ChromeTest {

    @Test
    void sslCheck() {

        /*Site com as capabilities do Chrome
        * https://chromedriver.chromium.org/capabilities*/

        // Objeto criado para lidar com a certificação
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        options.addExtensions("")

        // Para utilizar proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipadress:4444");
        options.setCapability("proxy",proxy);

        // Bloqueando pop ups
        options.setExperimentalOption("excludeSwitches",
                                        Arrays.asList("disable-popup-blocking"));

        // Mudando diretório do download
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options); // faz necessário dizer para o driver como ele deve se comportar, quais opções deve utilizar

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
