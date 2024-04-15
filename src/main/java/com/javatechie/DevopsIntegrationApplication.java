package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsIntegrationApplication {

	@GetMapping
	public String message(){
		return "DevOps Demo Project";
	}

	public static void main(String[] args) {
		SpringApplication.run(DevopsIntegrationApplication.class, "DevOps Demo Project");

		//SpringApplication application = new SpringApplication(MyApplication.class);
  // Customize application settings here
  //application.run(args);
	}

}
