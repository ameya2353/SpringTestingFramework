package com.spring.test.driver.remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;

// class created needs to be further explored
@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;


    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "FIRE_FOX")
    public WebDriver remoteFirefoxDriver(){
        return new RemoteWebDriver(this.url, new DesiredCapabilities());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "CHROME")
    public WebDriver remoteChromeDriver(){
        return new RemoteWebDriver(this.url, new DesiredCapabilities());
    }

}
