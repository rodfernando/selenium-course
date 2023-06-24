package br.com.testngtutorial;

import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;

public class Test1 {

    @Test (priority = 1)
    void test1() {

        System.out.println("heelllllow");
    }

    @Test (priority = 0)
    void test2() {

        System.out.println("WOooorld");
    }

    @Test (priority = 2)
    void test3() {

        System.out.println("EEEEita");
    }
}
