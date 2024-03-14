//package com.eurodyn.controller.people;
//
//import com.eurodyn.model.people.Director;
//import com.eurodyn.service.people.DirectorService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/director")
//public class DirectrorController {
//    private final DirectorService directorService;
//
//    @PostMapping("/create")
//    public Director createDirector(@RequestBody Director director) {
//
//        return directorService.create(director);
//    }
//
//    @GetMapping()
//    public List<Director> readDirector() {
//        return directorService.read();
//    }
//
//    @GetMapping("/{directorId}")
//    public Director getDirector(@PathVariable long directorId) {
//        return directorService.read(directorId);
//    }
//
//    @PutMapping("/{directorId}")
//    public Director updateDirector(@PathVariable long directorId, @RequestBody Director newDirector) {
//        return directorService.update(directorId, newDirector);
//    }
//
//
//    @DeleteMapping("/{directorId}")
//    public Director deleteDirector(@PathVariable long directorId) {
//        return directorService.delete(directorId);
//    }
//
//}
