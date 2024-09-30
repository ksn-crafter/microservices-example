package io.movie.ratings_data_service.models;

import java.util.List;

public class UserRating {
    List<Rating> userRatings;

    public UserRating(){}

    public UserRating(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
}
