package com.example.servicefilmdetails.controller;

import com.example.servicefilmdetails.dto.FilmAggregateDTO;
import com.example.servicefilmdetails.service.FilmAggregationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aggregation")
@Slf4j
@Tag(name = "Film Aggregation API", description = "Endpoints for aggregated film information")
@RequiredArgsConstructor
public class FilmAggregationController {

    private final FilmAggregationService filmAggregationService;

    @GetMapping("/films/{id}")
    @Operation(summary = "Get aggregated film details", description = "Retrieves all details for a film including personnel, genres, and reviews")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved film details"),
            @ApiResponse(responseCode = "404", description = "Film not found")
    })
    public ResponseEntity<FilmAggregateDTO> getFilmDetails(@Parameter(description = "ID of the film") @PathVariable Long id) {
        log.info("Requesting aggregated details for film ID: {}", id);
        try {
            FilmAggregateDTO film = filmAggregationService.getFilmDetails(id);
            return ResponseEntity.ok(film);
        } catch (RuntimeException e) {
            log.warn("Failed to fetch film details for ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}