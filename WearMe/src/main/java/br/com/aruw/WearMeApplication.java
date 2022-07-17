package br.com.aruw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class WearMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WearMeApplication.class, args);
	}

}