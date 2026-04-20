package com.utkarsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh.Menu;
import com.utkarsh.dto.BmiRequest;
import com.utkarsh.service.CafeService;

import java.util.Map;
import java.util.HashMap;

//This annotation tells SpringBoot this class is responsible to handle the web request.
@RestController
public class CafeController {

    // @Autowired: Dependency Injection! Spring Boot automatically hands us a
    // ready-to-use CafeService object.
    @Autowired
    private CafeService cafeService;

    @GetMapping("/api/welcome")
    public Map<String, String> getWelcomeMessage() {

        // Previously we used Sout , but in spirngboot we just return the data and it
        // autimatically converts it into JSON!
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Shukla's Cafe");
        response.put("status", "Server is Up and handling the request");

        return response;
    }

    // Endpoint for Full Menu
    @GetMapping("/api/menu")
    public Map<String, Menu> showMenu() {
        return cafeService.getFullMenu();
    }

    // @RequestBody annotation tells the spering to read the incoming json.
    @PostMapping("/api/bmi")
    public String calculateBmi(@RequestBody BmiRequest request) {

        // check if the data is getting cath or not
        return "Recieved data for " + request.getName() + " with weight "
                + request.getWeight() + "kg " + "height " + request.getHeight();
    }

}
