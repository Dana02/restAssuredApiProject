package com.udemy.java.supplier;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "/home/qa/.arquillian/drone/chrome/2.38/chromedriver");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "/home/qa/.arquillian/drone/firefox/geckodriver");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", firefoxSupplier);
    }

    public static WebDriver getDriver(String browser) {
        return MAP.get(browser).get();
    }

    public static void main(String[] args) {
//        Supplier<Double> random = Math::random;
//        System.out.println(random.get());
//
//        List<String> list = new ArrayList<>();
//        list.add("123");
//        list.add("323");
//
//        Consumer<String> consumer = System.out::println;
//        //list.forEach(consumer);
//        list.forEach(s -> System.out.println(s));


//        BiConsumer<String, Integer> biConsumer = (s, i) -> {
//            System.out.println("integer - " + i);
//            System.out.println("string - " + s);
//        };
//
//        biConsumer.accept("hi", 3);

        Consumer<String> loggConsumer = (s) -> {
            System.out.println("logging");
        };
        Consumer<String> dbConsumer = (s) -> {
            System.out.println("db");
        };

        Map<String, Consumer<String>> map = new HashMap<>();
        map.put("db", dbConsumer);
        map.put("logg", loggConsumer);
        map.put("db1", dbConsumer);

        map.forEach((k, v) -> {
            System.out.println("Key " + k);
        });
    }
}
