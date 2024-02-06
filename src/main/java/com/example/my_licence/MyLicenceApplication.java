package com.example.my_licence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyLicenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLicenceApplication.class, args);
    }
        @RequestMapping("/")
        public String hello () {
            return "hello world";
        }

    }
