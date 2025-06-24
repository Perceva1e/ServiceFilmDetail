package com.example.servicefilmdetails.dto;

import lombok.Data;

import java.util.List;

@Data
public class FilmAggregateDTO {
    private Long id;
    private String title;
    private int releaseYear;
    private String originalLanguage;
    private Integer duration;
    private Double rating;
    private FilmDataDTO filmData;
    private List<GenreDTO> genres;
    private List<PersonnelDTO> personnel;
    private List<ReviewDTO> reviews;
}

@Data
class FilmDataDTO {
    private Long id;
    private double rating;
    private double budget;
    private String poster;
    private String trailer;
    private double revenue;
}

@Data
class GenreDTO {
    private Long id;
    private String name;
    private String description;
}

@Data
class PersonnelDTO {
    private Long id;
    private String position;
    private PersonDTO person;
}

@Data
class PersonDTO {
    private Long id;
    private String name;
    private String biography;
    private String photograph;
}

@Data
class ReviewDTO {
    private Long id;
    private int rating;
    private int numberOfLikes;
    private int numberOfDislikes;
    private String reviewText;
    private String publicationDate;
    private UserDTO user;
}

@Data
class UserDTO {
    private Long id;
    private String email;
    private String name;
}