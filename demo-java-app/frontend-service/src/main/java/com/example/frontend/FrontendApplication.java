package com.example.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(FrontendApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Frontend Application");
        SpringApplication.run(FrontendApplication.class, args);
        logger.info("Frontend Application started successfully on port 8080");
    }
}