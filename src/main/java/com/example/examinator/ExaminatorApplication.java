package com.example.examinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExaminatorApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }





    public static void main(String[] args) {
        SpringApplication.run(ExaminatorApplication.class, args);
    }
}
