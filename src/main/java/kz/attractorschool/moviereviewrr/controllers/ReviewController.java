package kz.attractorschool.moviereviewrr.controllers;

import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/getAllReviewsForOneMovie")
    public List<Review> getAllReviewsForOneMovie(@RequestParam("movieName") String movieName) {
        return reviewService.findReviewsForOneMovie(movieName);
    }

    @GetMapping("/getReviewByUser")
    private List<Review> getReviewByUser(@RequestParam("userId") String userId){
        return reviewService.findReviewsByReviewer(userId);
    }

    @GetMapping("/getReviewByMovie")
    private List<Review> getReviewByMovie(@RequestParam("movieId") String movieId){
        return reviewService.findReviewsByMovie(movieId);
    }

    @GetMapping("/getReviewByMovieAndUser")
    private Review getReviewByMovie(@RequestParam("userId") String userId, @RequestParam("movieId") String movieId){
        Review review = reviewService.findIsThereReviewForMovie(userId, movieId);
        if (review == null) {
            throw new IllegalArgumentException();
        }
        return review;
    }
}
