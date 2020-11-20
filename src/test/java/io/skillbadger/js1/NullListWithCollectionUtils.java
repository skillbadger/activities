package io.skillbadger.js1;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NullListWithCollectionUtils {

    private List<String> toUpperCase(List<String> listOfStrings) {

        List<String> newListOfStrings = CollectionUtils
                .emptyIfNull(listOfStrings)
                .stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return newListOfStrings;

    }

    @Test
    void handleNullValuesInStream() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = toUpperCase(listOfStrings);

        assertEquals(2, newListOfStrings.size());
        assertEquals("HELLO", newListOfStrings.get(0));
        assertEquals("WORLD", newListOfStrings.get(1));

    }

    @Test
    void handleNullList() {

        List<String> newListOfStrings = toUpperCase(null);

        assertEquals(0, newListOfStrings.size());

    }
}
