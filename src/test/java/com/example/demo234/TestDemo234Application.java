package com.example.demo234;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemo234Application {

    public static void main(String[] args) {
        SpringApplication.from(Demo234Application::main).with(TestDemo234Application.class).run(args);
    }

}
