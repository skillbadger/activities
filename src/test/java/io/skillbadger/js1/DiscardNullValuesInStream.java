package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscardNullValuesInStream {

    @Test
    void discardNullValues() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(2, newListOfStrings.size());
        assertEquals("HELLO", newListOfStrings.get(0));
        assertEquals("WORLD", newListOfStrings.get(1));

    }
}
