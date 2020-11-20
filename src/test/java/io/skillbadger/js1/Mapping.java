package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Mapping {

    @Test
    void mapStream() {

        List<String> listOfStrings = Arrays.asList("hello", "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .filter(string -> string.startsWith("w"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(1, newListOfStrings.size());
        assertEquals("WORLD", newListOfStrings.get(0));

    }
}
