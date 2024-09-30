package io.movie.movie_info_service.rest;

import io.movie.movie_info_service.models.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable String movieId){
        return new Movie(movieId,"Transformers");
    }
}
