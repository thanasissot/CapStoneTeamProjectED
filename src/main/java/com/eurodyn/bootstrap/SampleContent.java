package com.eurodyn.bootstrap;

import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.Person;
import com.eurodyn.service.people.ActorService;
import com.eurodyn.service.people.CrewMemberService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final ActorService actorService;
    private final CrewMemberService crewMemberService;


    @Override
    public void run(String... args) throws Exception {
        Actor actor1 = createActor("actor1", BigDecimal.valueOf(500), Person.SalaryType.PER_EPISODE, null, null, null);
        Actor actor2 = createActor("actor2", BigDecimal.valueOf(20000), Person.SalaryType.PER_FULL_PROJECT, null, null, null);

    }

    private Actor createActor(String name, BigDecimal salary, Person.SalaryType salaryType,
                              List<Movie> movieList, List<TvShow> tvShowList, List<Nomination> nominationList) {
        Actor actor = new Actor();
        actor.setName(name);
        actor.setType(salaryType);
        actor.setSalary(salary);
        actor.setMovies(movieList);
        actor.setTvShows(tvShowList);
        actor.setNominations(nominationList);

        return actorService.create(actor);
    }

}
