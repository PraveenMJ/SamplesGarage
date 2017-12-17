package com.enterprise.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseApplication.class);

	public static void main(String[] args) {

		LOGGER.info("Enterprise Application started....");
		
		SpringApplication.run(EnterpriseApplication.class,args);
	}
}
