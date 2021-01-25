package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    List<Movie> findAll();
    Movie findMovieById(String id);
    Movie findMovieByTitle(String title);
    List<Movie> findMoviesByReleaseYear(int releaseYear);
    List<Movie> findMoviesByActorsContaining(String actor);
    List<Movie> findMoviesByRating(int rating);
    Page<Movie> findAll(Pageable pageable);
}
