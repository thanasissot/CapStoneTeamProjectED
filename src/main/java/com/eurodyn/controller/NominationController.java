//package com.eurodyn.controller;
//
//import com.eurodyn.dto.ResponseApi;
//import com.eurodyn.exception.NominationException;
//import com.eurodyn.model.Nomination;
//import com.eurodyn.service.NominationService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/nominations")
//@AllArgsConstructor
//public class NominationController {
//    private final NominationService nominationService;
//
//    @PostMapping("/create")
//    public ResponseApi<Nomination> create(@RequestBody Nomination nomination) {
//        // save data
//        ResponseApi<Nomination> result =  new ResponseApi<>();
//        result.setData(nominationService.create(nomination));
//        return result;
//    }
//
//    @GetMapping()
//    public ResponseApi<List<Nomination>> readNominations() {
//        ResponseApi<List<Nomination>> result =  new ResponseApi<>();
//        result.setData(nominationService.read());
//        return result;
//    }
//
//    @GetMapping("/{nominationId}")
//    public ResponseApi<Nomination>  getNomination(@PathVariable long nominationId) {
//        ResponseApi<Nomination> result =  new ResponseApi<>();
//        result.setData(nominationService.read(nominationId));
//        return result;
//    }
//
//    @PutMapping("/{nominationId}")
//    public ResponseApi<Nomination> updateNomination(@PathVariable long nominationId, @RequestBody Nomination newNomination) {
//        ResponseApi<Nomination> result =  new ResponseApi<>();
//        result.setData(nominationService.update(nominationId, newNomination));
//        return result;
//    }
//
//    @DeleteMapping("/{nominationId}")
//    public ResponseApi<Nomination> deleteCustomer(@PathVariable long nominationId) {
//        ResponseApi<Nomination> result =  new ResponseApi<>();
//        result.setData(nominationService.delete(nominationId));
//        return result;
//    }
//
//}
