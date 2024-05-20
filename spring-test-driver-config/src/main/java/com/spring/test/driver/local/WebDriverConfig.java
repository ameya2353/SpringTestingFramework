package com.spring.test.driver.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Configuration
@Profile("local")
public class WebDriverConfig {

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "EDGE")
    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "FIRE_FOX")
    public WebDriver fireDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new EdgeDriver();
    }

    @Bean
    @Scope("browserscope")
    @ConditionalOnProperty(name = "browser", havingValue = "CHROME")
    public WebDriver chromeDriver() {
           WebDriverManager.chromedriver().setup();
           return new ChromeDriver();
    }


}
