package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class KeepNullValuesInStream {

    @Test
    void noHandlingThrowsException() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        assertThrows(NullPointerException.class,
                () -> listOfStrings.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList())
        );

    }

    @Test
    void keepNullValuesWithIfBody() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .map(s -> {
                    if (s == null) {
                        return null;
                    } else {
                        return s.toUpperCase();
                    }
                })
                .collect(Collectors.toList());

        checkAssertions(newListOfStrings);

    }

    @Test
    void keepNullValuesWithIfTernary() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .map(s -> s == null ? null : s.toUpperCase())
                .collect(Collectors.toList());

        checkAssertions(newListOfStrings);

    }

    @Test
    void keepNullValuesWithOptional() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .map(s -> Optional.ofNullable(s)
                        .map(String::toUpperCase)
                        .orElse(null))
                .collect(Collectors.toList());

        checkAssertions(newListOfStrings);

    }

    @Test
    void keepNullValuesWithHelperFunction() {

        List<String> listOfStrings = Arrays.asList("hello", null, "world");

        List<String> newListOfStrings = listOfStrings.stream()
                .map(protect(String::toUpperCase))
                .collect(Collectors.toList());

        checkAssertions(newListOfStrings);
    }

    private static void checkAssertions(List<String> newListOfStrings) {
        assertEquals(3, newListOfStrings.size());
        assertEquals("HELLO", newListOfStrings.get(0));
        assertNull(newListOfStrings.get(1));
        assertEquals("WORLD", newListOfStrings.get(2));
    }

    public static <S, T> Function<S, T> protect(Function<S, T> fn) {
        return s -> Optional.ofNullable(s)
                .map(fn)
                .orElse(null);
    }
}
