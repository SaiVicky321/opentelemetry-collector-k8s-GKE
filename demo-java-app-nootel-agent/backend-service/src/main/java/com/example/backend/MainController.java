package com.example.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
public class MainController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/api/data")
    public String getData() {
        logger.info("GET /api/data endpoint called - received request from frontend");
        
        String response = "Backend response at " + Instant.now();
        logger.info("Sending response to frontend: {}", response);
        
        return response;
    }
}