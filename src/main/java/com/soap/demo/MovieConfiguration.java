package com.soap.demo;

import com.soap.demo.models.MovieClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MovieConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("localhost._8080.movies");
        return marshaller;
    }

    @Bean
    public MovieClient movieClient(Jaxb2Marshaller marshaller){
        MovieClient movieClient = new MovieClient();
        movieClient.setDefaultUri("http://localhost:8080/movies");
        movieClient.setMarshaller(marshaller);
        movieClient.setUnmarshaller(marshaller);
        return movieClient;
    }


}
