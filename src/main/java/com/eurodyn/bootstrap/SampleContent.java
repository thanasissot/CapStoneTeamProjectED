package com.eurodyn.bootstrap;

import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.model.people.*;
import com.eurodyn.service.media.MovieService;
import com.eurodyn.service.media.TvShowService;
import com.eurodyn.service.people.ActorService;
import com.eurodyn.service.people.CrewMemberService;
import com.eurodyn.service.people.DirectorService;
import com.eurodyn.service.people.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final ActorService actorService;
    private final MovieService movieService;
    private final CrewMemberService crewMemberService;
    private final TvShowService tvShowService;
    private final DirectorService directorService;
    private final ProducerService producerService;


    @Override
    public void run(String... args) throws Exception {
        List<Actor> actors = createActorList();
        List<CrewMember> crewMembers = createCrewMembers();
        List<Director> directors = createDirectorList();
        List<Producer> producers = createProducerList();
        List<Movie> movies = createMovieList(actors, directors, producers, crewMembers);
        List<TvShow>tvShows = createTvShowList(actors,directors, producers, crewMembers);


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

    private Movie createMovie(Director director, Integer productionBudget, Integer yearOfRelease, List<Actor> actorList, List<Producer> producerList, List<CrewMember> crewMemberList, String genre, String title) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setDirector(director);
        movie.setYearOfRelease(yearOfRelease);
        movie.setProductionBudget(BigDecimal.valueOf(productionBudget));
        movie.setActors(actorList);
        movie.setCrewMembers(crewMemberList);
        movie.setProducers(producerList);

        return movieService.create(movie);
    }

    private TvShow createTvShow(Director director, BigDecimal minBudget, BigDecimal maxBudget, Integer startingYear, Integer endingYear,
                                Integer numberOfEpisodes, List<Actor> actorList, List<Producer> producerList, List<CrewMember> crewMemberList, String genre, String title) {
        TvShow tvShow = new TvShow();
        tvShow.setTitle(title);
        tvShow.setGenre(genre);
        tvShow.setDirector(director);
        tvShow.setStartingYear(startingYear);
        tvShow.setEndingYear(endingYear);
        tvShow.setMinBudget(minBudget);
        tvShow.setMaxBudget(maxBudget);
        tvShow.setActors(actorList);
        tvShow.setNumberOfEpisodes(numberOfEpisodes);
        tvShow.setCrewMembers(crewMemberList);
        tvShow.setProducers(producerList);

        return tvShowService.create(tvShow);
    }

    private List<Movie> createMovieList(List<Actor> actors, List<Director> directors, List<Producer> producers, List<CrewMember> crewMembers){
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = createMovie(directors.get(0),1000000000,2023,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie1");
        Movie movie2 = createMovie(directors.get(1),250000000,2009,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie2");
        Movie movie3 = createMovie(directors.get(2),1000000000,2023,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie3");
        Movie movie4 = createMovie(directors.get(3),250000000,2009,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie4");
        Movie movie5 = createMovie(directors.get(4),1000000000,2023,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie5");
        Movie movie6 = createMovie(directors.get(5),250000000,2009,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie6");
        Movie movie7 = createMovie(directors.get(6),1000000000,2023,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie7");
        Movie movie8 = createMovie(directors.get(7),250000000,2009,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie8");
        Movie movie9 = createMovie(directors.get(8),1000000000,2023,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie9");
        Movie movie10 = createMovie(directors.get(9),250000000,2009,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers), "action", "Movie10");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);
        movies.add(movie10);

        return movies;

    }



    private List<TvShow> createTvShowList(List<Actor> actors, List<Director> directors, List<Producer> producers, List<CrewMember> crewMembers){
        List<TvShow> tvShows = new ArrayList<>();
        TvShow tvShow1 = createTvShow(directors.get(0),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2020,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show1" );
        TvShow tvShow2 = createTvShow(directors.get(1),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2021,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show2" );
        TvShow tvShow3 = createTvShow(directors.get(2),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2000,2001,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show3" );
        TvShow tvShow4 = createTvShow(directors.get(3),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2020,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show4" );
        TvShow tvShow5 = createTvShow(directors.get(4),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2022,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show5" );
        TvShow tvShow6 = createTvShow(directors.get(5),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2020,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show6" );
        TvShow tvShow7 = createTvShow(directors.get(6),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2023,2024,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show7" );
        TvShow tvShow8 = createTvShow(directors.get(7),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2020,2023,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show8" );
        TvShow tvShow9 = createTvShow(directors.get(8),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2021,2022,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show9" );
        TvShow tvShow10 = createTvShow(directors.get(9),BigDecimal.valueOf(1200000000),BigDecimal.valueOf(300000000),2009,2010,50,getRandomActors(actors),getRandomProducers(producers),getRandomCrewMembers(crewMembers),"action","Show10" );


        tvShows.add(tvShow1);
        tvShows.add(tvShow2);
        tvShows.add(tvShow3);
        tvShows.add(tvShow4);
        tvShows.add(tvShow5);
        tvShows.add(tvShow6);
        tvShows.add(tvShow7);
        tvShows.add(tvShow8);
        tvShows.add(tvShow9);
        tvShows.add(tvShow10);

        return tvShows;

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
    public static List<Actor> getRandomActors(List<Actor> originalList) {
        // Create a new list to store random objects
        List<Actor> randomObjects = new ArrayList<>();

        int originalSize = originalList.size();

        Random random = new Random();

        int numObjectsToSelect = random.nextInt(3) + 4;

        // Select random objects from the original list
        for (int i = 0; i < numObjectsToSelect; i++) {
            // Generate a random index to select an object from the original list
            int randomIndex = random.nextInt(originalSize);

            // Add the randomly selected object to the new list
            randomObjects.add(originalList.get(randomIndex));
        }

        return randomObjects;
    }
    public static List<Producer> getRandomProducers(List<Producer> originalList) {
        // Create a new list to store random objects
        List<Producer> randomObjects = new ArrayList<>();

        int originalSize = originalList.size();

        Random random = new Random();

        int numObjectsToSelect = random.nextInt(3) + 4;

        // Select random objects from the original list
        for (int i = 0; i < numObjectsToSelect; i++) {
            // Generate a random index to select an object from the original list
            int randomIndex = random.nextInt(originalSize);

            // Add the randomly selected object to the new list
            randomObjects.add(originalList.get(randomIndex));
        }

        return randomObjects;
    }

    public static List<CrewMember> getRandomCrewMembers(List<CrewMember> originalList) {
        // Create a new list to store random objects
        List<CrewMember> randomObjects = new ArrayList<>();

        int originalSize = originalList.size();

        Random random = new Random();

        int numObjectsToSelect = random.nextInt(3) + 4;

        // Select random objects from the original list
        for (int i = 0; i < numObjectsToSelect; i++) {
            // Generate a random index to select an object from the original list
            int randomIndex = random.nextInt(originalSize);

            // Add the randomly selected object to the new list
            randomObjects.add(originalList.get(randomIndex));
        }

        return randomObjects;
    }
}
