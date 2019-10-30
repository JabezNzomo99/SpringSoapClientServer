package com.soap.demo;

import com.soap.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface MoviRepository extends CrudRepository<Movie, Long> {

    public Movie getMovieByMovieName(String movieName);
    public List<Movie> getMovieByMovieGenre(String movieGenre);

}
