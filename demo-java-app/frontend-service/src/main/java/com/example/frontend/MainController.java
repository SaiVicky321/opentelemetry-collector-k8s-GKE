package com.example.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Value("${BACKEND_URL:http://localhost:8081}")
    private String backendUrl;

    @GetMapping("/")
    public String home() {
        logger.info("Home endpoint called - received request from client");
        
        RestTemplate rest = new RestTemplate();
        String backendEndpoint = backendUrl + "/api/data";
        
        logger.info("Calling backend service: {}", backendEndpoint);
        
        try {
            String backendResponse = rest.getForObject(backendEndpoint, String.class);
            logger.info("Backend response received successfully: {}", backendResponse);
            
            String frontendResponse = "Frontend: called backend → " + backendResponse;
            logger.info("Sending response to client: {}", frontendResponse);
            
            return frontendResponse;
        } catch (Exception e) {
            logger.error("Error calling backend service: {} - {}", backendEndpoint, e.getMessage());
            return "Frontend: Error calling backend";
        }
    }
}