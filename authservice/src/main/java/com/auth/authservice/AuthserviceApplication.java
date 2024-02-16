package com.auth.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthserviceApplication {

	public static void main(String[] args) {
		System.out.println("Auth Service Is Up And Running !!... ");
		SpringApplication.run(AuthserviceApplication.class, args);
	}

}
