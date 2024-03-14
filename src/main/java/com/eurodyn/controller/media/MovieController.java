//package com.eurodyn.controller.media;
//
//
//import com.eurodyn.model.media.Movie;
//import com.eurodyn.service.media.MovieService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/movie")
//@AllArgsConstructor
//public class MovieController {
//
//    private final MovieService movieService;
//
//    @GetMapping()
//    public List<Movie> readMovie() {
//        return movieService.read();
//    }
//
//    @GetMapping("/{movieId}")
//    public Movie getMovie(@PathVariable long movieId) {
//        return movieService.read(movieId);
//    }
//
//    @PutMapping("/{movieId}")
//    public Movie updateMovie(@PathVariable long movieId, @RequestBody Movie newMovie) {
//        return movieService.update(movieId, newMovie);
//    }
//
//
//    @DeleteMapping("/{movieId}")
//    public Movie deleteTvShow(@PathVariable long movieId) {
//        return movieService.delete(movieId);
//    }
//
//
//}
