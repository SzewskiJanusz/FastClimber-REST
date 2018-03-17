package com.fastclimber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class FastClimberRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) 
	{
		SpringApplication.run(FastClimberRestApplication.class, args);
	}
}
