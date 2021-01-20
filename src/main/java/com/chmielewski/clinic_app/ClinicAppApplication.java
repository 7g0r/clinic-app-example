package com.chmielewski.clinic_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClinicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicAppApplication.class, args);
    }
}
