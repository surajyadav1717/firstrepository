package com.example.demo;

import com.example.demo.controller.AuthController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudJspFormatApplication {

    private final AuthController employeeController;

    CrudJspFormatApplication(AuthController employeeController) {
        this.employeeController = employeeController;
    }

	public static void main(String[] args) {
		SpringApplication.run(CrudJspFormatApplication.class, args);
		
		System.out.println("Application Started At Port 3333");
	}

}
