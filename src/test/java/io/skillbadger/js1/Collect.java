package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Collect {

    @Test
    void collectStream() {

        List<String> listOfStrings = Arrays.asList("hello", "world");
        Stream<String> streamOfStrings = listOfStrings.stream();

        List<String> newListOfStrings = streamOfStrings
                .collect(Collectors.toList());

        assertEquals(2, newListOfStrings.size());
        assertEquals("hello", newListOfStrings.get(0));
        assertEquals("world", newListOfStrings.get(1));

    }


}
