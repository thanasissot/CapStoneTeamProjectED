//package com.eurodyn.controller.media;
//
//import com.eurodyn.model.media.TvShow;
//import com.eurodyn.service.media.TvShowService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/tvShow")
//public class TvShowController {
//
//    private final TvShowService tvShowService;
//
//    @GetMapping()
//    public List<TvShow> readTvShow() {
//        return tvShowService.read();
//    }
//
//    @GetMapping("/{tvShowId}")
//    public TvShow getTvShow(@PathVariable long tvShowId) {
//        return tvShowService.read(tvShowId);
//    }
//
//    @PutMapping("/{tvShowId}")
//    public TvShow updateTvShow(@PathVariable long tvShowId, @RequestBody TvShow newTvShow) {
//        return tvShowService.update(tvShowId, newTvShow);
//    }
//
//
//    @DeleteMapping("/{tvShowId}")
//    public TvShow deleteTvShow(@PathVariable long tvShowId) {
//        return tvShowService.delete(tvShowId);
//    }
//
//}
