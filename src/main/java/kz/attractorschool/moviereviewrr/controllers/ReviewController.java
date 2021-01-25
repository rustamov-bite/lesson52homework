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

    @GetMapping("/getReviewsForOneMovie")
    public List<Review> getReviewsForOneMovie(@RequestParam("movieName") String movieName) {
        return reviewService.findReviewsForOneMovie(movieName);
    }

    @GetMapping("getAllForMovie")
    private List<Review> getAllForMovie(@RequestParam("movieName") String movieName) {
        return reviewService.findAllReviewsForMovie(movieName);
    }

    @GetMapping("/getReviewByUser")
    private List<Review> getReviewByUser(@RequestParam("userId") String userId){
        return reviewService.findReviewsByReviewer(userId);
    }

    @GetMapping("/getReviewByMovieAndUser")
    private boolean getReviewByMovie(@RequestParam("userId") String userId, @RequestParam("movieId") String movieId){
        return reviewService.findIsThereReviewForMovie(userId, movieId);

    }
}
