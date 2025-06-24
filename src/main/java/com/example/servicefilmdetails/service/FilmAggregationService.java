package com.example.servicefilmdetails.service;

import com.example.servicefilmdetails.client.FilmClient;
import com.example.servicefilmdetails.dto.FilmAggregateDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmAggregationService {

    private final FilmClient filmClient;

    public FilmAggregateDTO getFilmDetails(Long id) {
        log.info("Fetching detailed film information for ID: {}", id);
        FilmAggregateDTO film = filmClient.getFilmById(id);
        if (film == null) {
            log.warn("Film with ID {} not found", id);
            throw new RuntimeException("Film not found");
        }
        log.debug("Retrieved film details: {}", film.getTitle());
        return film;
    }
}