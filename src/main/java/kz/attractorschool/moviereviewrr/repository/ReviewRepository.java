package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.model.Review;
import kz.attractorschool.moviereviewrr.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
    List<Review> findAll();
    Review findReviewById(String id);
    List<Review> findAllByMovie(Movie movie);
    List<Review> findReviewByReviewer(User reviewer);
    List<Review> findReviewsByMovie(Movie movie);
    boolean existsByReviewerAndMovie(User user, Movie movie);
}
