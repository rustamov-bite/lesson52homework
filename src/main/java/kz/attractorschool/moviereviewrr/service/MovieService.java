package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie findMovieById(String id) {
        return movieRepository.findMovieById(id);
    }

    public List<Movie> findByName(String title) {
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : movieRepository.findAll()) {
            if (m.getTitle().contains(title)) {
                movieList.add(m);
            }
        }
        return movieList;
    }

    public List<Movie> findByYear(int year) {
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : movieRepository.findAll()) {
            if (m.getReleaseYear() == year) {
                movieList.add(m);
            }
        }
        return movieList;
    }

    public List<Movie> findByActor(String actor) {
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : movieRepository.findAll()) {
            for (String a : m.getActors()) {
                if (a.equals(actor)) {
                    movieList.add(m);
                }
            }
        }
        return movieList;
    }

    public List<Movie> findByStar(int star) {
        List<Movie> movieList = new ArrayList<>();
        for (Movie m : movieRepository.findAll()) {
            if (m.getRating() == star) {
                movieList.add(m);
            }
        }
        return movieList;
    }
}
