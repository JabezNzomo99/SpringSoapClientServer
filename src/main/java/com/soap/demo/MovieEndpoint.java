package com.soap.demo;


import localhost._8080.movies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class MovieEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/movies";

    private MovieRepository movieRepository;


    @Autowired
    public MovieEndpoint(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieRequest")
    @ResponsePayload
    public GetMovieResponse getMovieRequest(@RequestPayload GetMovieRequest request) {
        GetMovieResponse response = new GetMovieResponse();
        response.setMovie(movieRepository.getMovie(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMoviesRequest")
    @ResponsePayload
    public GetAllMoviesResponse getAllMovies(@RequestPayload GetAllMoviesRequest getAllMoviesRequest){
       GetAllMoviesResponse getAllMoviesResponse = new GetAllMoviesResponse();
       for(Movie movie : movieRepository.getAllMovies()){
           getAllMoviesResponse.getMovie().add(movie);
       }
       return getAllMoviesResponse;
    }
}

