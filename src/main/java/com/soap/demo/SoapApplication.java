package com.soap.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@EntityScan({"com.soap.demo.*"})
@EnableJpaRepositories(basePackageClasses = MoviRepository.class)
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

}
