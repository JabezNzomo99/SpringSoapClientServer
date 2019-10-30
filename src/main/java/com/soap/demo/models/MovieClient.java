package com.soap.demo.models;

import localhost._8080.movies.GetAllMoviesRequest;
import localhost._8080.movies.GetAllMoviesResponse;
import localhost._8080.movies.GetMovieRequest;
import localhost._8080.movies.GetMovieResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MovieClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(MovieClient.class);

    public GetAllMoviesResponse getAllMovies(){

        GetAllMoviesRequest getAllMoviesRequest = new GetAllMoviesRequest();
        log.info("****** Requesting for all movies ******");

        GetAllMoviesResponse response = (GetAllMoviesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/movies",getAllMoviesRequest,
                        new SoapActionCallback("http://localhost:8080/movies"));
        return response;
    }

    public GetMovieResponse getMovie(String movieName){
        GetMovieRequest getMovieRequest = new GetMovieRequest();
        getMovieRequest.setName(movieName);
        GetMovieResponse response = (GetMovieResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/movies",getMovieRequest,
                        new SoapActionCallback("http://localhost:8080/movies"));
        return response;
    }
}
