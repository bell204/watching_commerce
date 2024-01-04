package com.watching.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchingApplication.class, args);
	}

}
