package com.example.favorito_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FavoritoServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FavoritoServiceApplication.class, args);
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" MicroServicio Favorito Operativo - Puerto 8085");
        System.out.println(" http://localhost:8085/api/favoritos");
        System.out.println("=".repeat(50) + "\n");
    }
}