package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiPredicateTest {

    @Test
    public void explicit() {
        BiPredicate<Set<String>, String> bipredicate = new BiPredicate<Set<String>, String>() {
            @Override
            public boolean test(Set<String> strings, String s) {
                return strings.contains(s);
            }
        };
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        boolean result = bipredicate.test(strings, "hello");
        assertTrue(result);
    }

    @Test
    public void lambda() {
        BiPredicate<Set<String>, String> bipredicate = (strings, s) -> strings.contains(s);
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        boolean result = bipredicate.test(strings, "hello");
        assertTrue(result);
    }

    @Test
    public void methodReference() {
        BiPredicate<Set<String>, String> bipredicate = Set::contains;
        Set<String> strings = new HashSet<>();
        strings.add("hello");
        boolean result = bipredicate.test(strings, "hello");
        assertTrue(result);
    }
}
