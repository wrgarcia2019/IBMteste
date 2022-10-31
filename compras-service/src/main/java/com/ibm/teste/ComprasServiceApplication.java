package com.ibm.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ComprasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComprasServiceApplication.class, args);
	}

}
