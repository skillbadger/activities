package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MappingToDifferentType {

    @Test
    void mapStreamDifferentType() {

        List<String> listOfStrings = Arrays.asList("hello", "world");

        List<Integer> newListOfStrings = listOfStrings.stream()
                .filter(string -> string.startsWith("w"))
                .map(String::length)
                .collect(Collectors.toList());

        assertEquals(1, newListOfStrings.size());
        assertEquals(5, newListOfStrings.get(0));

    }
}
