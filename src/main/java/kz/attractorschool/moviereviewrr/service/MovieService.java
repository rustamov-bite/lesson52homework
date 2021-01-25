package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie findMovieById(String id) {
        return movieRepository.findMovieById(id);
    }

    public Movie findByName(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    public List<Movie> findByYear(int year) {
        return movieRepository.findMoviesByReleaseYear(year);
    }

    public List<Movie> findByActor(String actor) {
        return movieRepository.findMoviesByActorsContaining(actor);
    }

    public List<Movie> findByStar(int star) {
        return movieRepository.findMoviesByRating(star);
    }

    public Page<Movie> sortByName() {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        int page = 1;
        int size = 3;
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(pageable);
    }

    public Page<Movie> sortingByRating() {
        Sort sort = Sort.by(Sort.Order.desc("star"));
        int page = 1;
        int size = 3;
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findAll(pageable);
    }
}
