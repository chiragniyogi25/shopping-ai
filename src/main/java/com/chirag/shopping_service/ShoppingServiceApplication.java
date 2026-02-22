package com.chirag.shopping_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ShoppingServiceApplication {

	public static void main(String[] args) {
        // FORCE JVM timezone permanently for this app
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(ShoppingServiceApplication.class, args);
	}

}
