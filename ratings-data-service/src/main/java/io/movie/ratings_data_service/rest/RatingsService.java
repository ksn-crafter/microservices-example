package io.movie.ratings_data_service.rest;
import io.movie.ratings_data_service.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.movie.ratings_data_service.models.Rating;
import io.movie.ratings_data_service.models.UserRating;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/rating")
public class RatingsService {

    @Value("${no.config:defaultValue}")
    private String someConfig;


    private DbSettings dbSettings;

    @Value("${list.values}")
    private List<String> list;

    @Value("#{${my.map}}")
    private Map<String,String> map;

    @Value("${my.greetings: local greeting}")
    private String greeting;

    @Autowired
    public RatingsService(DbSettings dbSettings) {
        this.dbSettings = dbSettings;
    }

    @GetMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable String movieId){
        return new Rating(movieId,3);
    }

    @GetMapping("/user/{userId}")
    public UserRating getRatingsByUser(@PathVariable String userId){
        return new UserRating(Arrays.asList(new Rating("123",5),
                new Rating("456",4)));
    }

    @GetMapping("/greeting")
    public String getGreeting(){
        return greeting;
    }

    @GetMapping("/random")
    public String doSomething(){
        return dbSettings.toString();
    }
}
