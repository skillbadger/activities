package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NullListWithOptional {

    private List<String> toUpperCase(List<String> listOfStrings) {
        Stream<String> streamOfStrings = Optional.ofNullable(listOfStrings)
                .stream()
                .flatMap(Collection::stream);

        List<String> newListOfStrings = streamOfStrings.filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return newListOfStrings;
    }

    @Test
    void nonNullList() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = toUpperCase(listOfStrings);

        assertEquals(2, newListOfStrings.size());
        assertEquals("HELLO", newListOfStrings.get(0));
        assertEquals("WORLD", newListOfStrings.get(1));

    }

    @Test
    void nullList() {

        List<String> newListOfStrings = toUpperCase(null);

        assertEquals(0, newListOfStrings.size());

    }
}
