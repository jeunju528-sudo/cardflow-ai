package com.cardflow.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cardflow.finance.mapper")
public class CardflowAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardflowAiApplication.class, args);
	}

}
