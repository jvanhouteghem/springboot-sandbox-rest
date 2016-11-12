package com.jvanhouteghem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringbootSandboxRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSandboxRestApplication.class, args);
	}
}
