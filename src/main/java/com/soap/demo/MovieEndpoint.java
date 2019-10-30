package com.soap.demo;


import localhost._7000.movie.GetMovieRequest;
import localhost._7000.movie.GetMovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;




@Endpoint
public class MovieEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


    private MovieRepository movieRepository;


    @Autowired
    public MovieEndpoint(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieRequest")
    @ResponsePayload
    public GetMovieResponse getMovie(@RequestPayload GetMovieRequest request) {
        GetMovieResponse response = new GetMovieResponse();
        response.setMovie(movieRepository.getMovie(request.getName()));
        return response;
    }
}

