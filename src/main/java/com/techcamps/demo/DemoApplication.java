package com.techcamps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// necessário pois classes components (annotations) não estão em pacotes ou subpacotes de onde main (essa classe) está
@ComponentScan(basePackages = "com.techcamps")
@EnableJpaRepositories(basePackages = "com.techcamps")
@EntityScan(basePackages = "com.techcamps")
@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
