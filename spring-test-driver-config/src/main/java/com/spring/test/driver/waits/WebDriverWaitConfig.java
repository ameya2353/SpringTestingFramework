package com.spring.test.driver.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Lazy
@Configuration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    private  int timeout;

    @Value("${default.timeout.unit:SECONDS}")
    private  ChronoUnit unit;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.of(this.timeout, unit));
    }
}
