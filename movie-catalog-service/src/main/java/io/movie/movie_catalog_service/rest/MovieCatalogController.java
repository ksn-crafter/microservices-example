package io.movie.movie_catalog_service.rest;
import io.movie.movie_catalog_service.models.CatalogItem;
import io.movie.movie_catalog_service.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import io.movie.movie_catalog_service.models.Movie;
import io.movie.movie_catalog_service.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public MovieCatalogController(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
       System.out.println("Here is a user id => " + userId);
       UserRating  userRating = webClientBuilder.build()
                               .get()
                               .uri(String.format("http://ratings-data-service/rating/user/%s",userId))
                               .retrieve()
                               .bodyToMono(UserRating.class)
                               .block();

      return userRating.getUserRatings().stream().map(rating -> {
         Movie movie = webClientBuilder.build()
                   .get()
                   .uri(String.format("http://movie-info-service/movies/%s",rating.getMovieId()))
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();
           return new CatalogItem(movie.getName(),movie.getMovieId(),rating.getRating());
       }).collect(Collectors.toList());
    }
}
