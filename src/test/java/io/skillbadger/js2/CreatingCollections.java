package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatingCollections {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void list() {

        List<String> result = createStream()
                .collect(Collectors.toList());

        assertEquals(6, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "not", "to", "be"},
                result.toArray(new String[]{})
        );

    }

    @Test
    void set() {

        Set<String> result = createStream()
                .collect(Collectors.toSet());

        assertEquals(4, result.size());
        assertTrue(result.contains("to"));
        assertTrue(result.contains("be"));
        assertTrue(result.contains("or"));
        assertTrue(result.contains("not"));

    }

    @Test
    void arbitraryCollection() {

        LinkedList<String> result = createStream()
                .collect(Collectors.toCollection(LinkedList::new));

        assertEquals(6, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "not", "to", "be"},
                result.toArray(new String[]{})
        );

    }

    @Test
    void unmodifiableList() {

        List<String> result = createStream()
                .collect(Collectors.toUnmodifiableList());

        assertEquals(6, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "not", "to", "be"},
                result.toArray(new String[]{})
        );

        assertThrows(
                UnsupportedOperationException.class,
                () -> result.set(0, result.get(0))
        );

    }

    @Test
    void unmodifiableSet() {

        Set<String> result = createStream()
                .collect(Collectors.toUnmodifiableSet());

        assertEquals(4, result.size());
        assertTrue(result.contains("to"));
        assertTrue(result.contains("be"));
        assertTrue(result.contains("or"));
        assertTrue(result.contains("not"));

        assertThrows(
                UnsupportedOperationException.class,
                () -> result.add("to")
        );

    }

}
