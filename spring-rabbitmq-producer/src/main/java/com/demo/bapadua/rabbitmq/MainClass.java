package com.demo.bapadua.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);
    }
}
