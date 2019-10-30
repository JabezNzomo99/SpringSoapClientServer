package com.soap.demo;

import com.soap.demo.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {

    public static Map<String, Movie> movies = new HashMap<>();

    private final MoviRepository moviRepository;


    public MovieRepository(MoviRepository moviRepository){
        this.moviRepository = moviRepository;
    }

    @PostConstruct
    public void populateMovies(){
        System.out.println("At least i tried");
        Movie movie1 = new Movie("The Arrow","ACTION",2010);
        Movie movie2 = new Movie("Iron Man","Sci-fi",2007);
        Movie movie3 = new Movie("Love You","ROMANCE",2011);
        moviRepository.save(movie1);
        moviRepository.save(movie2);
        moviRepository.save(movie3);
    }

    public localhost._8080.movies.Movie getMovie(String movieName){
        Movie movie = moviRepository.getMovieByMovieName(movieName);
        localhost._8080.movies.Movie m = new localhost._8080.movies.Movie();
        m.setName(movie.getMovieName());
        m.setGenre(movie.getMovieGenre());
        m.setYearReleased(movie.getYearReleased());
        return m;
    }

   public List<localhost._8080.movies.Movie> getAllMovies(){
        List<localhost._8080.movies.Movie> movieArrayList = new ArrayList<localhost._8080.movies.Movie>();
        Iterable<Movie> movies = moviRepository.findAll();
        for(Movie movie : movies){
            localhost._8080.movies.Movie m = new localhost._8080.movies.Movie();
            m.setName(movie.getMovieName());
            m.setGenre(movie.getMovieGenre());
            m.setYearReleased(movie.getYearReleased());
            movieArrayList.add(m);
        }
        return movieArrayList;
   }


}
