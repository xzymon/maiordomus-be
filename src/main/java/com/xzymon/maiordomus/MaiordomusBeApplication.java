package com.xzymon.maiordomus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MaiordomusBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaiordomusBeApplication.class, args);
	}

}
