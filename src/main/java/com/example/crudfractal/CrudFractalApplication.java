package com.example.crudfractal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.repository")
@ComponentScan("com.example.*")
public class CrudFractalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudFractalApplication.class, args);
    }

}
