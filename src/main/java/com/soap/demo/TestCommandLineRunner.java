package com.soap.demo;

import com.soap.demo.models.MovieClient;
import localhost._8080.movies.GetAllMoviesResponse;
import localhost._8080.movies.GetMovieResponse;
import localhost._8080.movies.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner implements CommandLineRunner {

    private final MovieClient movieClient;

    private TestCommandLineRunner(MovieClient movieClient){
        this.movieClient = movieClient;
    }

    @Override
    public void run(String... args) throws Exception {
        GetAllMoviesResponse response = movieClient.getAllMovies();
        for(Movie movie : response.getMovie()){
            System.out.print("Movie Name : " + movie.getName());
            System.out.print(" Movie Genre : " + movie.getGenre());
            System.out.println(" Year of Release : " + movie.getYearReleased());
        }

        GetMovieResponse getMovieResponse = movieClient.getMovie("Iron Man");
        System.out.print("Movie Name : " + getMovieResponse.getMovie().getName());
        System.out.print(" Movie Genre : " + getMovieResponse.getMovie().getGenre());
        System.out.println(" Year of Release : " + getMovieResponse.getMovie().getYearReleased());

    }
}
