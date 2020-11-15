package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

    @Test
    public void explicit() {
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return strings.contains(string);
            }
        };
        boolean result = predicate.test("hello");
        assertTrue(result);
    }

    @Test
    public void lambda() {
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        Predicate<String> predicate = string -> strings.contains(string);
        boolean result = predicate.test("hello");
        assertTrue(result);
    }

    @Test
    public void methodReference() {
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        Predicate<String> predicate = strings::contains;
        boolean result = predicate.test("hello");
        assertTrue(result);
    }
}
