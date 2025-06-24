package com.example.servicefilmdetails.client;

import com.example.servicefilmdetails.dto.FilmAggregateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FilmClient {

    private final RestTemplate restTemplate;

    @Autowired
    public FilmClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FilmAggregateDTO getFilmById(Long id) {
        return restTemplate.getForObject("/films/{id}", FilmAggregateDTO.class, id);
    }
}