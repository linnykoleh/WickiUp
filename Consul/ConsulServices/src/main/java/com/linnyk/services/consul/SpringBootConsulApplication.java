package com.linnyk.services.consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootConsulApplication {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String message() {
        System.out.println("Hello " + port);
        return "Hello from " + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsulApplication.class, args);
    }

}
