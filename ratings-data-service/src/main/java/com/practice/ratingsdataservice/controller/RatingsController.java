package com.practice.ratingsdataservice.controller;

import com.practice.ratingsdataservice.model.Rating;
import com.practice.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId,4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
