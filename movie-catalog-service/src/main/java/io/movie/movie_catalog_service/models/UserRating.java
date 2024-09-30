package io.movie.movie_catalog_service.models;

import java.util.List;
import java.util.ArrayList;

public class UserRating {
    List<Rating> userRatings;

    public UserRating(){}

    public UserRating(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return userRatings == null ? new ArrayList<Rating>() : userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
