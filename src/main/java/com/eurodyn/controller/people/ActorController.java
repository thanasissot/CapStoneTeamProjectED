//package com.eurodyn.controller.people;
//import com.eurodyn.model.people.Actor;
//import com.eurodyn.service.people.ActorService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/actor")
//public class ActorController {
//
//    private final ActorService actorService;
//
//    @GetMapping()
//    public List<Actor> readActor() {
//        return actorService.read();
//    }
//
//    @GetMapping("/{actorId}")
//    public Actor getActor(@PathVariable long actorId) {
//        return actorService.read(actorId);
//    }
//
//    @PutMapping("/{actorId}")
//    public Actor updateActor(@PathVariable long actorId, @RequestBody Actor newActor) {
//        return actorService.update(actorId, newActor);
//    }
//
//
//    @DeleteMapping("/{actorId}")
//    public Actor deleteActor(@PathVariable long actorId) {
//        return actorService.delete(actorId);
//    }
//
//}
