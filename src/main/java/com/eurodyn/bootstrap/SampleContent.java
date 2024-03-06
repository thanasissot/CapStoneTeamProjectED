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

        return actor;
    }

}
