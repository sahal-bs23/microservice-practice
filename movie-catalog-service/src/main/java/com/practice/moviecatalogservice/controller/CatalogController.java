package com.practice.moviecatalogservice.controller;

import com.practice.moviecatalogservice.model.CatalogItem;
import com.practice.moviecatalogservice.model.UserRating;
import com.practice.moviecatalogservice.service.MovieInfo;
import com.practice.moviecatalogservice.service.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogController {


    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getRatings().stream().map(
                rating -> {
                    return movieInfo.getCatalogItem(rating);
                }
        ).collect(Collectors.toList());
    }
}
