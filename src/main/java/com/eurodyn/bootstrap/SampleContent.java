package com.eurodyn.bootstrap;

import com.eurodyn.exception.NominationException;
import com.eurodyn.model.*;
import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.people.*;
import com.eurodyn.repository.*;
import com.eurodyn.service.GenreService;
import com.eurodyn.service.NominationService;
import com.eurodyn.service.media.MovieService;
import com.eurodyn.service.media.TvShowService;
import com.eurodyn.service.people.ActorService;
import com.eurodyn.service.people.CrewMemberService;
import com.eurodyn.service.people.DirectorService;
import com.eurodyn.service.people.ProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Component
@Log4j2
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final ActorService actorService;
    private final MovieService movieService;
    private final CrewMemberService crewMemberService;
    private final TvShowService tvShowService;
    private final DirectorService directorService;
    private final ProducerService producerService;
    private final GenreService genreService;
	private final NominationService nominationService;

    private final NominationRepository nominationRepository;
    private final NominationWonRepository nominationWonRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final UserRatingRepository userRatingRepository;

    @Override
	@Transactional
    public void run(String... args) throws Exception {
        List<Genre> genres = createGenres();
        List<Actor> actors = createActorList();
        List<CrewMember> crewMembers = createCrewMembers();
        Set<Director> directors = createDirectorList();
        Set<Producer> producers = createProducerList();

//        Media movie1 = createMovie(null,1222,2023,null,null,null, genres.get(0), "Movie111");


        Set<Movie> movies = createMovieList(new ArrayList<>(actors), new ArrayList<>(directors), new ArrayList<>(producers), new ArrayList<>(crewMembers), genres);
        System.out.printf(" a");

        Actor actor1 = createActor("actor11", BigDecimal.valueOf(500), Person.SalaryType.PER_EPISODE,
                null, null);
        new ArrayList<>(movies).get(0).getActors().add(actor1);
        movieService.create(new ArrayList<>(movies).getFirst());

        Set<Movie> movies1 = new HashSet<>(movieService.read());
        Actor actor2 = actorService.read(1L);
        actor2.getMediaActors();
        System.out.println();

        BigDecimal a = movieService.findCost((Media) new ArrayList<>(movies).getFirst());
        System.out.println();

        Nomination nomination = new Nomination();
        nomination.setMovie(new ArrayList<>(movies).get(1));
		// add actor to the movie and then to nomination because of business constraints
		new ArrayList<>(movies).get(1).getActors().add(actor1);
		movieService.create(new ArrayList<>(movies).get(1));
		nomination.setActor(actor1);
        nomination = nominationService.create(nomination);

        Nomination nomination1 = new Nomination();
        nomination1.setMovie(new ArrayList<>(movies).get(2));
		// add actor to the movie and then to nomination because of business constraints
//		new ArrayList<>(movies).get(2).getActors().add(actors.getFirst());
//		movieService.create(new ArrayList<>(movies).get(2));
        nomination1.setActor(actors.getFirst());
        nomination1 = nominationService.create(nomination1);

        // same movie different actor nominated
        Nomination nomination2 = new Nomination();
        nomination2.setMovie(new ArrayList<>(movies).get(2));
		// add actor to the movie and then to nomination because of business constraints
		new ArrayList<>(movies).get(2).getActors().add(actors.get(1));
		movieService.create(new ArrayList<>(movies).get(2));
        nomination2.setActor(actors.get(1));
        nomination2 = nominationService.create(nomination2);

		// will throw exception because we are trying to nominate an actor
		// for a movie he didnt participate in
		try {
			Nomination nomination3 = new Nomination();
			nomination3.setMovie(new ArrayList<>(movies).get(3));
			nomination3.setActor(actors.get(1));
			nomination3 = nominationService.create(nomination3);
		} catch (NominationException e) {
			log.error(e.getLocalizedMessage());
		}

        AppUser appUser = new AppUser();
        appUser.setFullName("new user1");
        appUser = userRepository.save(appUser);

        UserRating userRating = new UserRating();
        userRating.setAppUser(appUser);
        userRating.setNomination(nomination);
        userRating.setRating(9.5f);
        userRating = userRatingRepository.save(userRating);

        NominationWon nominationWon = new NominationWon();
        nominationWon.setNomination(nomination);
        nominationWon.setGenre(nomination.getGenre());
        nominationWon.setYearOfRelease(nomination.getNominationYear());
        nominationWon = nominationWonRepository.save(nominationWon);

        NominationWon nominationWon1 = new NominationWon();
        nominationWon1.setNomination(nomination1);
        nominationWon1.setGenre(nomination1.getGenre());
        nominationWon1.setYearOfRelease(nomination1.getNominationYear());
        nominationWon1 = nominationWonRepository.save(nominationWon1);

        // DataIntegrityViolationException thrown as expected
//        NominationWon nominationWon2 = new NominationWon();
//        nominationWon2.setNomination(nomination2);
//        nominationWon2.setGenre(nomination2.getGenre());
//        nominationWon2.setYearOfRelease(nomination2.getNominationYear());
//        nominationWon2 = nominationWonRepository.save(nominationWon2);

        System.out.println();

    }
    public List<Genre> createGenres() {
        Genre a = new Genre();
        a.setName(Genre.GenreName.ACTION);

        Genre b = new Genre();
        b.setName(Genre.GenreName.COMEDY);

        Genre c = new Genre();
        c.setName(Genre.GenreName.DRAMA);

        Genre d = new Genre();
        d.setName(Genre.GenreName.HORROR);

        return genreService.createAll(List.of(a,b,c,d));
    }

    private Actor createActor(String name, BigDecimal salary, Person.SalaryType salaryType,
                              Set<Media> mediaList, List<Nomination> nominationList) {
        Actor actor = new Actor();
        actor.setName(name);
        actor.setType(salaryType);
        actor.setSalary(salary);
        actor.setMediaActors(mediaList);
        actor.setNominations(nominationList);

        return actorService.create(actor);
    }

    private CrewMember createCrewMember(String name, BigDecimal salary, Person.SalaryType salaryType,
                                        Set<Media> mediaList) {
        CrewMember crewMember = new CrewMember();
        crewMember.setName(name);
        crewMember.setType(salaryType);
        crewMember.setSalary(salary);
        crewMember.setMediaCrews(mediaList);

        return crewMemberService.create(crewMember);
    }

    private Director createDirector(String name, BigDecimal salary, Person.SalaryType salaryType,
                                    Set<Media> mediaList) {
        Director director = new Director();
        director.setName(name);
        director.setType(salaryType);
        director.setSalary(salary);
        director.setMediaDirector(mediaList);


        return directorService.create(director);
    }

    private Producer createProducer(String name, BigDecimal salary, Person.SalaryType salaryType,
                                    Set<Media> mediaList) {
        Producer producer = new Producer();
        producer.setName(name);
        producer.setType(salaryType);
        producer.setSalary(salary);
        producer.setMediaProducers(mediaList);


        return producerService.create(producer);
    }

    private List<Actor> createActorList() {
        List<Actor> actors = new ArrayList<>();
        Actor actor1 = createActor("actor1", BigDecimal.valueOf(50000), Person.SalaryType.PER_FULL_PROJECT,
                null, null);
        Actor actor2 = createActor("actor2", BigDecimal.valueOf(4500), Person.SalaryType.PER_EPISODE,
                null, null);

        actors.add(actor1);
        actors.add(actor2);

        return actors;
    }

    private List<CrewMember> createCrewMembers() {
        List<CrewMember> crewMembers = new ArrayList<>();
        CrewMember crewMember1 = createCrewMember("crewMember1", BigDecimal.valueOf(501), Person.SalaryType.PER_EPISODE,
                null);


        crewMembers.add(crewMember1);

        return crewMembers;
    }

    private Movie createMovie(Director director, Integer productionBudget, Integer yearOfRelease, Set<Actor> actorList, Set<Producer> producerList, Set<CrewMember> crewMemberList, Genre genre, String title) {
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


    private Set<Movie> createMovieList(List<Actor> actors, List<Director> directors, List<Producer> producers, List<CrewMember> crewMembers, List<Genre> genres){
        Set<Movie> movies = new HashSet<>();
        Movie movie1 = createMovie(directors.get(0),1000000000,2123,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie1");
        Movie movie2 = createMovie(directors.get(0),250000000,2209,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie2");
        Movie movie3 = createMovie(directors.get(0),1000000000,2323,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie3");
        Movie movie4 = createMovie(directors.get(0),250000000,2409,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie4");
        Movie movie5 = createMovie(directors.get(0),1000000000,2523,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie5");
        Movie movie6 = createMovie(directors.get(0),250000000,2609,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie6");
        Movie movie7 = createMovie(directors.get(0),1000000000,2723,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie7");
        Movie movie8 = createMovie(directors.get(0),250000000,2809,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie8");
        Movie movie9 = createMovie(directors.get(0),1000000000,2923,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie9");
        Movie movie10 = createMovie(directors.get(0),250000000,2119,new HashSet<>(getRandomActors(actors)),new HashSet<>(getRandomProducers(producers)),new HashSet<>(getRandomCrewMembers(crewMembers)), genres.get(0), "Movie10");

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

    private Set<Director> createDirectorList() {
        Set<Director> directors = new HashSet<>();
        Director director1 = createDirector("director1", BigDecimal.valueOf(600), Person.SalaryType.PER_EPISODE,
                null);
        directors.add(director1);

        return directors;
    }

    private Set<Producer> createProducerList() {
        Set<Producer> producers = new HashSet<>();
        Producer producer1 = createProducer("producer1", BigDecimal.valueOf(300), Person.SalaryType.PER_EPISODE,
                null);
        producers.add(producer1);
        Producer producer2 = createProducer("producer2", BigDecimal.valueOf(300), Person.SalaryType.PER_EPISODE,
                null);
        producers.add(producer2);

        return producers;
    }
    public static List<Actor> getRandomActors(List<Actor> originalList) {
        // Create a new list to store random objects
        List<Actor> randomObjects = new ArrayList<>();

        int originalSize = originalList.size();

        Random random = new Random();

//        int numObjectsToSelect = random.nextInt(3) + 4;
        int numObjectsToSelect = 1;

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

        //        int numObjectsToSelect = random.nextInt(3) + 4;
        int numObjectsToSelect = 2;

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

        //        int numObjectsToSelect = random.nextInt(3) + 4;
        int numObjectsToSelect = 1;

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
