package com.example.proiect_masini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.proiect_masini")
public class ProiectMasiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectMasiniApplication.class, args);
	}
}
