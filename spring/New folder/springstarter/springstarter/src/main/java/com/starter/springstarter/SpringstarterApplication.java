package com.starter.springstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringstarterApplication {

	public static void main(String[] args) {
		
		System.setProperty("com.sun.xml.bind.v2.runtime.JAXBContextImpl.fastBoot", "false");
		System.setProperty("com.sun.xml.bind.v2.runtime.JAXBContextImpl.fastBoot", "false");

		SpringApplication.run(SpringstarterApplication.class, args);
	}

}
