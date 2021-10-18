package com.artofmaes.funiversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.artofmaes.funiversity")
public class FuniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuniversityApplication.class, args);
	}

}
