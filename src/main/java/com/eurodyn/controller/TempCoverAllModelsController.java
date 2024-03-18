package com.eurodyn.controller;

import com.eurodyn.dto.NominationDto;
import com.eurodyn.dto.ResponseApi;
import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.dto.people.ActorFullDto;
import com.eurodyn.service.NominationService;
import com.eurodyn.service.media.MovieService;
import com.eurodyn.service.people.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor
public class TempCoverAllModelsController {
	private final NominationService nominationService;
	private final MovieService movieService;
	private final ActorService actorService;

	//
//    @PostMapping("/create")
//    public ResponseApi<Nomination> create(@RequestBody Nomination nomination) {
//        // save data
//        ResponseApi<Nomination> result =  new ResponseApi<>();
//        result.setData(nominationService.create(nomination));
//        return result;
//    }
//
	@GetMapping("/nominations")
	public ResponseApi<List<NominationDto>> readNominations() {
		ResponseApi<List<NominationDto>> result = new ResponseApi<>();
		result.setData(nominationService.readNominationsDto());
		return result;
	}

	@GetMapping("/movies")
	public ResponseApi<List<MovieDto>> readMovies() {
		ResponseApi<List<MovieDto>> result = new ResponseApi<>();
		result.setData(movieService.readMoviesDto());
		return result;
	}

	@GetMapping("/actors")
	public ResponseApi<List<ActorFullDto>> readActors() {
		ResponseApi<List<ActorFullDto>> result = new ResponseApi<>();
		result.setData(actorService.readActorsDto());
		return result;
	}
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
}
