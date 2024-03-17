package com.eurodyn.service.media;

import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.model.people.Person;

import java.math.BigDecimal;
import java.util.HashSet;

public interface FindCost {
    default BigDecimal findCost(Media media) {
        BigDecimal cost = BigDecimal.ZERO;

        HashSet<Person> persons = new HashSet<>();
        persons.addAll(media.getActors());
        persons.addAll(media.getProducers());
        persons.addAll(media.getCrewMembers());
        persons.add(media.getDirector());

        for (Person person : persons) {
            if (person.getType().equals(Person.SalaryType.PER_FULL_PROJECT)) {
                cost = cost.add(person.getSalary());
            }
            else if (media instanceof TvShow) {
                cost = cost.add(person.getSalary().multiply(BigDecimal.valueOf(((TvShow) media).getNumberOfEpisodes())));
            } else {
                cost = cost.add(person.getSalary().multiply(BigDecimal.valueOf(20L)));
            }
        }

        return cost;
    }
}
