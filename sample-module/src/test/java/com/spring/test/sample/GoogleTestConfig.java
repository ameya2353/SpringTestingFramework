package com.spring.test.sample;

import com.spring.test.pagerepo.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class GoogleTestConfig {
    @Autowired
    private GooglePage googlePage;

    @Bean
    public boolean goToGooglePage(){
        this.googlePage.goToGooglePage();
        return this.googlePage.isAt();
    }

    @Bean
    public boolean search(){
        this.googlePage.getSearchComponent().search("spring boot");
        return this.googlePage.getSearchResult().isAt();
    }

    @Bean
    public boolean checkCountGreaterThan2(){
        return this.googlePage.getSearchResult().getCount() > 2;
    }




}
