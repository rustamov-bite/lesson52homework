package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }


    public List<Review> findReviewsForOneMovie(String movie) {
        List<Review> reviews = new ArrayList<>();
        for (Review r : reviewRepository.findAll()) {
            if (r.getMovie().getTitle().equals(movie)) {
                reviews.add(r);
            }
        }
        return reviews;
    }

    public List<Review> findReviewsByReviewer(String userId) {
        List<Review> reviews = new ArrayList<>();
        for (Review r : reviewRepository.findAll()) {
            if (r.getReviewer().getId().equals(userId)) {
                reviews.add(r);
            }
        }
        return reviews;
    }

    public List<Review> findReviewsByMovie(String movieId) {
        List<Review> reviews = new ArrayList<>();
        for (Review r : reviewRepository.findAll()) {
            if (r.getMovie().getId().equals(movieId)) {
                reviews.add(r);
            }
        }
        return reviews;
    }

    public Review findIsThereReviewForMovie(String userId, String movieId) {
        boolean found = false;
        Review review = new Review();
        for (Review r : reviewRepository.findAll()) {
            if (r.getMovie().getId().equals(movieId) && r.getReviewer().getId().equals(userId)) {
                found = true;
                review = r;
                break;
            }
        }
        if (found) {
            return review;
        } else {
            return null;
        }
    }

    public Review findReviewById(String id) {
        return reviewRepository.findReviewById(id);
    }

    public void saveAllReviews(List<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }

    public void saveOneReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteAllReviews(List<Review> reviews) {
        reviewRepository.deleteAll(reviews);
    }

    public void deleteOneReview(Review review) {
        reviewRepository.delete(review);
    }
}
