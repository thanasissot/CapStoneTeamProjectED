package com.eurodyn.bootstrap;

import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.model.people.*;
import com.eurodyn.service.people.ActorService;
import com.eurodyn.service.people.CrewMemberService;
import com.eurodyn.service.people.DirectorService;
import com.eurodyn.service.people.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final ActorService actorService;
    private final CrewMemberService crewMemberService;
    private final DirectorService directorService;
    private final ProducerService producerService;


    @Override
    public void run(String... args) throws Exception {
        List<Actor> actors = createActorList();
        List<CrewMember> crewMembers = createCrewMembers();


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

    private CrewMember createCrewMember(String name, BigDecimal salary, Person.SalaryType salaryType,
                                   List<Movie> movieList, List<TvShow> tvShowList) {
        CrewMember crewMember = new CrewMember();
        crewMember.setName(name);
        crewMember.setType(salaryType);
        crewMember.setSalary(salary);
        crewMember.setMovies(movieList);
        crewMember.setTvShows(tvShowList);

        return crewMemberService.create(crewMember);
    }

    private Director createDirector(String name, BigDecimal salary, Person.SalaryType salaryType,
                                 List<Movie> movieList, List<TvShow> tvShowList) {
        Director director = new Director();
        director.setName(name);
        director.setType(salaryType);
        director.setSalary(salary);
        director.setMovies(movieList);
        director.setTvShows(tvShowList);


        return directorService.create(director);
    }

    private Producer createProducer(String name, BigDecimal salary, Person.SalaryType salaryType,
                                    List<Movie> movieList, List<TvShow> tvShowList) {
        Producer producer = new Producer();
        producer.setName(name);
        producer.setType(salaryType);
        producer.setSalary(salary);
        producer.setMovies(movieList);
        producer.setTvShows(tvShowList);


        return producerService.create(producer);
    }

    private List<Actor> createActorList() {
        List<Actor> actors = new ArrayList<>();
        Actor actor1 = createActor("actor1", BigDecimal.valueOf(500), Person.SalaryType.PER_EPISODE,
                null, null, null);
        Actor actor2 = createActor("actor2", BigDecimal.valueOf(20000), Person.SalaryType.PER_FULL_PROJECT,
                null, null, null);
        Actor actor3 = createActor("actor3", BigDecimal.valueOf(511), Person.SalaryType.PER_EPISODE,
                null, null, null);
        Actor actor4 = createActor("actor4", BigDecimal.valueOf(21000), Person.SalaryType.PER_FULL_PROJECT,
                null, null, null);
        Actor actor5 = createActor("actor5", BigDecimal.valueOf(522), Person.SalaryType.PER_EPISODE,
                null, null, null);
        Actor actor6 = createActor("actor6", BigDecimal.valueOf(20333), Person.SalaryType.PER_FULL_PROJECT,
                null, null, null);
        Actor actor7 = createActor("actor7", BigDecimal.valueOf(533), Person.SalaryType.PER_EPISODE,
                null, null, null);
        Actor actor8 = createActor("actor8", BigDecimal.valueOf(22050), Person.SalaryType.PER_FULL_PROJECT,
                null, null, null);
        Actor actor9 = createActor("actor9", BigDecimal.valueOf(544), Person.SalaryType.PER_EPISODE,
                null, null, null);
        Actor actor10 = createActor("actor10", BigDecimal.valueOf(23035), Person.SalaryType.PER_FULL_PROJECT,
                null, null, null);

        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);
        actors.add(actor5);
        actors.add(actor6);
        actors.add(actor7);
        actors.add(actor8);
        actors.add(actor9);
        actors.add(actor10);

        return actors;
    }

    private List<CrewMember> createCrewMembers() {
        List<CrewMember> crewMembers = new ArrayList<>();
        CrewMember crewMember1 = createCrewMember("crewMember1", BigDecimal.valueOf(501), Person.SalaryType.PER_EPISODE,
                null, null);
        CrewMember crewMember2 = createCrewMember("crewMember2", BigDecimal.valueOf(20001), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        CrewMember crewMember3 = createCrewMember("crewMember3", BigDecimal.valueOf(512), Person.SalaryType.PER_EPISODE,
                null, null);
        CrewMember crewMember4 = createCrewMember("crewMember4", BigDecimal.valueOf(21002), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        CrewMember crewMember5 = createCrewMember("crewMember5", BigDecimal.valueOf(523), Person.SalaryType.PER_EPISODE,
                null, null);
        CrewMember crewMember6 = createCrewMember("crewMember6", BigDecimal.valueOf(20334), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        CrewMember crewMember7 = createCrewMember("crewMember7", BigDecimal.valueOf(534), Person.SalaryType.PER_EPISODE,
                null, null);
        CrewMember crewMember8 = createCrewMember("crewMember8", BigDecimal.valueOf(22051), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        CrewMember crewMember9 = createCrewMember("crewMember9", BigDecimal.valueOf(545), Person.SalaryType.PER_EPISODE,
                null, null);
        CrewMember crewMember10 = createCrewMember("crewMember10", BigDecimal.valueOf(23036), Person.SalaryType.PER_FULL_PROJECT,
                null, null);

        crewMembers.add(crewMember1);
        crewMembers.add(crewMember2);
        crewMembers.add(crewMember3);
        crewMembers.add(crewMember4);
        crewMembers.add(crewMember5);
        crewMembers.add(crewMember6);
        crewMembers.add(crewMember7);
        crewMembers.add(crewMember8);
        crewMembers.add(crewMember9);
        crewMembers.add(crewMember10);

        return crewMembers;
    }


    private List<Director> createDirectorList() {
        List<Director> directors = new ArrayList<>();
        Director director1 = createDirector("director1", BigDecimal.valueOf(600), Person.SalaryType.PER_EPISODE,
                null, null);
        Director director2 = createDirector("director2", BigDecimal.valueOf(20200), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Director director3 = createDirector("director3", BigDecimal.valueOf(800), Person.SalaryType.PER_EPISODE,
                null, null);
        Director director4 = createDirector("director4", BigDecimal.valueOf(24000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Director director5 = createDirector("director5", BigDecimal.valueOf(988), Person.SalaryType.PER_EPISODE,
                null, null);
        Director director6 = createDirector("director6", BigDecimal.valueOf(20777), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Director director7 = createDirector("director7", BigDecimal.valueOf(455), Person.SalaryType.PER_EPISODE,
                null, null);
        Director director8 = createDirector("director8", BigDecimal.valueOf(21345), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Director director9 = createDirector("adirector9", BigDecimal.valueOf(900), Person.SalaryType.PER_EPISODE,
                null, null);
        Director director10 = createDirector("director10", BigDecimal.valueOf(20000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);

        directors.add(director1);
        directors.add(director2);
        directors.add(director3);
        directors.add(director4);
        directors.add(director5);
        directors.add(director6);
        directors.add(director7);
        directors.add(director8);
        directors.add(director9);
        directors.add(director10);

        return directors;
    }

    private List<Producer> createProducerList() {
        List<Producer> producers = new ArrayList<>();
        Producer producer1 = createProducer("producer1", BigDecimal.valueOf(300), Person.SalaryType.PER_EPISODE,
                null, null);
        Producer producer2 = createProducer("producer2", BigDecimal.valueOf(90000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Producer producer3 = createProducer("producer3", BigDecimal.valueOf(300), Person.SalaryType.PER_EPISODE,
                null, null);
        Producer producer4 = createProducer("producer4", BigDecimal.valueOf(23000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Producer producer5 = createProducer("producer5", BigDecimal.valueOf(455), Person.SalaryType.PER_EPISODE,
                null, null);
        Producer producer6 = createProducer("producer6", BigDecimal.valueOf(21000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Producer producer7 = createProducer("producer7", BigDecimal.valueOf(900), Person.SalaryType.PER_EPISODE,
                null, null);
        Producer producer8 = createProducer("producer8", BigDecimal.valueOf(21000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Producer producer9 = createProducer("producer9", BigDecimal.valueOf(700), Person.SalaryType.PER_EPISODE,
                null, null);
        Producer producer10 = createProducer("producer10", BigDecimal.valueOf(25000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);

        producers.add(producer1);
        producers.add(producer2);
        producers.add(producer3);
        producers.add(producer4);
        producers.add(producer5);
        producers.add(producer6);
        producers.add(producer7);
        producers.add(producer8);
        producers.add(producer9);
        producers.add(producer10);

        return producers;
    }

}
