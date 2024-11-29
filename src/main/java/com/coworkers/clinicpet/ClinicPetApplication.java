package com.coworkers.clinicpet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ClinicPetApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClinicPetApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(Environment environment) {
        return args -> {
            String port = environment.getProperty("server.port", "");
            System.out.println("La API está corriendo en el puerto: " + port);
            System.out.println("Listo ");

        };
    }



}
