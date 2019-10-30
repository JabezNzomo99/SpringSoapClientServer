package com.soap.demo.models;

import javax.persistence.*;

@Entity(name = "movies")
public class Movie {
    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long movieId;

    private String movieName;
    private String movieGenre;
    private Integer yearReleased;


    public Movie(String movieName, String movieGenre, Integer yearReleased) {
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.yearReleased = yearReleased;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Integer getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(Integer yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Movie(){

    }
}
