package com.spring.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BaseTestContext {
}
