package com.project.votepopularpet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VotePopularPetApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotePopularPetApplication.class, args);
	}

}
