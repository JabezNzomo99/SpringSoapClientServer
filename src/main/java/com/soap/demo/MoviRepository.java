package com.soap.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviRepository extends JpaRepository<Movie, Long> {

    public Movie getMovieByMovieName(String movieName);
    public List<Movie> getMovieByMovieGenre(String movieGenre);
}
