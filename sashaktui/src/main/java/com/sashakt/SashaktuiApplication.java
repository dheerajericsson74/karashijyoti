package com.sashakt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.sashakt.controller")
@EnableAutoConfiguration
@Configuration
public class SashaktuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SashaktuiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();

            List<String> result =  Arrays.asList(beanNames).stream().filter(name -> name.startsWith("com.sashakt")).collect(Collectors.toList());
            System.out.println(" -->>> "+result.size());
            result.forEach(System.out::println);
        };
    }
}
