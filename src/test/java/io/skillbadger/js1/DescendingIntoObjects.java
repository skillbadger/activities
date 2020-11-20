package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescendingIntoObjects {

    @Test
    void descend() {

        List<Person> listOfPersons = Arrays.asList(
                new Person("John", "Cook"),
                new Person("Robert", "Plumber"),
                new Person("Mary", "Baker")
        );

        List<String> listOfOccupations = listOfPersons
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getOccupation)
                .map(Occupation::getName)
                .collect(Collectors.toList());

        assertEquals(3, listOfOccupations.size());
        assertEquals("Cook", listOfOccupations.get(0));
        assertEquals("Plumber", listOfOccupations.get(1));
        assertEquals("Baker", listOfOccupations.get(2));

    }

    private static class Person {

        private String name;
        private Occupation occupation;

        public Person(String name, String occupation) {
            this.name = name;
            this.occupation = new Occupation(occupation);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Occupation getOccupation() {
            return occupation;
        }

        public void setOccupation(Occupation occupation) {
            this.occupation = occupation;
        }
    }

    private static class Occupation {

        private String name;

        public Occupation(String name) {

            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
