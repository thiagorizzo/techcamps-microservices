package com.techcamps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// necessário pois classes components (annotations) não estão em pacotes ou subpacotes de onde main (essa classe) está
@ComponentScan(basePackages = "com.techcamps")
@EnableJpaRepositories(basePackages = "com.techcamps")
@EntityScan(basePackages = "com.techcamps")

// https://stackoverflow.com/questions/28042426/spring-boot-error-creating-bean-with-name-datasource-defined-in-class-path-r
// if you don't need the datasource, simply remove it from the auto-config process
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

@SpringBootApplication()
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
