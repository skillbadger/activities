package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Filter {

    @Test
    void collectStream() {

        List<String> listOfStrings = Arrays.asList("hello", "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .filter(string -> string.startsWith("w"))
                .collect(Collectors.toList());

        assertEquals(1, newListOfStrings.size());
        assertEquals("world", newListOfStrings.get(0));

    }
}
