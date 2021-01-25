package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    public List<Review> findReviewsForOneMovie(String movie) {
        return reviewRepository.findReviewsByMovie(movieRepository.findMovieById(movie));
    }

    public List<Review> findAllReviewsForMovie(String movie) {
        return reviewRepository.findAllByMovie(movieRepository.findMovieById(movie));
    }

    public List<Review> findReviewsByReviewer(String userId) {
        return reviewRepository.findReviewByReviewer(userRepository.findUserById(userId));
    }

    public boolean findIsThereReviewForMovie(String userId, String movieId) {
        return reviewRepository.existsByReviewerAndMovie(userRepository.findUserById(userId), movieRepository.findMovieById(movieId));
    }
}
