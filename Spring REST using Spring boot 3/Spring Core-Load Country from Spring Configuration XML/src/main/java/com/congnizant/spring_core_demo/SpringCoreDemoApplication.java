package com.congnizant.spring_core_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {

		displayCountry();

		SpringApplication.run(SpringCoreDemoApplication.class, args);

	}

	public static void displayCountry() {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =
				context.getBean("country", Country.class);

		System.out.println(country);

	}
}