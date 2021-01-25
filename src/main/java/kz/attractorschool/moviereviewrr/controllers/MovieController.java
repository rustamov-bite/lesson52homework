package kz.attractorschool.moviereviewrr.controllers;

import kz.attractorschool.moviereviewrr.model.Movie;
import kz.attractorschool.moviereviewrr.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/getMovieByName")
    private Movie getMovieByName(@RequestParam("movieTitle") String movieTitle) {
        return movieService.findByName(movieTitle);
    }

    @GetMapping("/getMovieByYear")
    private List<Movie> getMovieByYear(@RequestParam("movieYear") String movieYear) {
        return movieService.findByYear(Integer.parseInt(movieYear));
    }

    @GetMapping("/getMovieByActor")
    private List<Movie> getMovieByActor(@RequestParam("movieActor") String movieActor) {
        return movieService.findByActor(movieActor);
    }

    @GetMapping("/getMovieByRating")
    private List<Movie> getMovieByRating(@RequestParam("movieRating") String movieRating) {
        return movieService.findByStar(Integer.parseInt(movieRating));
    }

    @GetMapping("/getPagedMovieSortedByName")
    private Page<Movie> getPagedMovieSortedByName() {
        return movieService.sortByName();
    }

    @GetMapping("/getPagedMovieSortedByRating")
    private Page<Movie> getPagedMovieSortedByRating() {
        return movieService.sortingByRating();
    }
}
