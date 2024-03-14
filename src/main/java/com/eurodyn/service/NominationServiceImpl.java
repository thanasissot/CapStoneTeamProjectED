//package com.eurodyn.service;
//
//import static com.eurodyn.model.Nomination.NominationType.NOMINATED;
//import static com.eurodyn.model.Nomination.NominationType.WON;
//
//import com.eurodyn.exception.NominationException;
//import com.eurodyn.model.Nomination;
//import com.eurodyn.model.people.Actor;
//import com.eurodyn.repository.NominationRepository;
//import java.util.ArrayList;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//@AllArgsConstructor
//public class NominationServiceImpl implements NominationService {
//
//  private final NominationRepository nominationRepository;
//
//  // create and update should verify 2 things
//  // 1. there is no same actor for same year and genre of nomination
//  // 2. there is only 1 WON result for same year and genre
//  // 3. we are making th year/genre/actor but only logically not defined in schema
//
//  @Override
//  public Nomination create(Nomination nomination) {
//    List<Nomination> nominations = nominationRepository.findAllByNominationYearAndGenre(
//        nomination.getNominationYear(), nomination.getGenre());
//
//    boolean nominationExists = nominations.stream().anyMatch(
//        nomination1 -> Objects.equals(nomination1.getActor().getId(),
//            nomination.getActor().getId()));
//    if (nominationExists) {
//      // throw exception cannot create
//      throw new NominationException(
//          "Year and Genre combination already exists - cannot create/update Nomination.");
//    }
//
//    if (nomination.getNominationResult().equals(WON)
//        && nominations.stream().anyMatch(nomination2 -> nomination2.getNominationResult().equals(
//        WON))
//    ) {
//      // throw exception cannot create WON already exists
//      throw new NominationException(
//          "Year and Genre and WON combination already exists - cannot create/update Nomination.");
//    }
//
//    return nominationRepository.save(nomination);
//  }
//
//  @Override
//  public List<Nomination> read() {
//    return nominationRepository.findAll();
//  }
//
//  @Override
//  public Nomination read(Long nominationId) {
//    return nominationRepository.findById(nominationId).orElse(null);
//  }
//
//  @Override
//  public Nomination update(Long nominationId, Nomination newNomination) {
//    newNomination.setId(nominationId);
//    return create(newNomination);
//  }
//
//  @Override
//  public Nomination delete(Long nominationId) {
//    Nomination nomination = read(nominationId);
//    if (nomination == null) {
//      return null;
//    }
//    nominationRepository.delete(nomination);
//    return nomination;
//  }
//
//  @Override
//  public List<Actor> getBestActors(Integer fromYear, Integer toYear) throws NominationException {
//      List<Nomination> nominations = this.nominationRepository.findByNominationYearBetween(
//              fromYear, toYear);
//      List<Actor> actors = new ArrayList<>();
//
//      if (Objects.nonNull(nominations)) {
//          nominations.forEach(nomination -> {
//              if (nomination.getNominationResult().equals(WON)) {
//                  actors.add(nomination.getActor());
//              }
//          });
//      } else {
//          throw new NominationException("Nomination for these year are not exist");
//      }
//
//      return actors;
//  }
//
//  public List<Actor> findByNominated(int x) {
//        List<Nomination> nominations = nominationRepository.findAllByNominationResult(Nomination.NominationType.NOMINATED);
//        Map<Actor, Integer> map = new HashMap<>();
//
//        for (Nomination nomination : nominations) {
//            map.put(nomination.getActor(), map.getOrDefault(nomination.getActor(), 0) + 1);
//        }
//
//        List<Actor> result = new ArrayList<>();
//        for(Actor actor : map.keySet()) {
//            if (map.get(actor) >= x) {
//                result.add(actor);
//            }
//        }
//
//        return result;
//  }
//
//
//}
