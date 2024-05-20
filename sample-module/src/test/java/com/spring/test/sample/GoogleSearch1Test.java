package com.spring.test.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Import(GoogleTestConfig.class)
public class GoogleSearch1Test {
    @Autowired @Qualifier("goToGooglePage") private Boolean googleLaunched;

    @Autowired @Qualifier("search") private Boolean search;

    @Autowired @Qualifier("search") private Boolean resultCount;

    @Test(priority = 1)
    public void GoogleTest() throws IOException, InterruptedException {
        Assert.assertTrue(googleLaunched);
    }

    @Test(priority = 2)
    public void GoogleTest2() throws IOException, InterruptedException {
        Assert.assertTrue(search);
    }

    @Test(priority = 3)
    public void GoogleTest3() throws IOException, InterruptedException {
        Assert.assertTrue(resultCount);

    }
}
