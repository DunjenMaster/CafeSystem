package com.utkarsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This annotation enables the auto-configuration of the application, component scanning, and setups Tomcat!
@SpringBootApplication
public class CafeApplication {

    public static void main(String[] args) {

        System.out.println("Starting the Cafe Application...");

        // This launches the web server instead of a Terminal Scanner
        SpringApplication.run(CafeApplication.class, args);
    }

}
