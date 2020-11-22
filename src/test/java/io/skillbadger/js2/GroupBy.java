package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupBy {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void groupByList() {

        Map<Integer, List<String>> result = createStream()
                .collect(Collectors.groupingBy(String::length));

        assertEquals(2, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "to", "be"},
                result.get(2).toArray(new String[]{})
        );
        assertArrayEquals(
                new String[]{"not"},
                result.get(3).toArray(new String[]{})
        );

    }

    @Test
    void groupBySet() {

        Map<Integer, Set<String>> result = createStream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()
                ));

        assertEquals(2, result.size());
        assertEquals(3, result.get(2).size());
        assertTrue(result.get(2).contains("to"));
        assertTrue(result.get(2).contains("be"));
        assertTrue(result.get(2).contains("or"));
        assertEquals(1, result.get(3).size());
        assertTrue(result.get(3).contains("not"));

    }

    @Test
    void groupByJoining() {

        Map<Integer, String> result = createStream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.joining(",")
                ));


        assertEquals(2, result.size());
        assertEquals("to,be,or,to,be", result.get(2));
        assertEquals("not", result.get(3));

    }

    @Test
    void groupBySetWithSupplier() {

        Map<Integer, Set<String>> result = createStream()
                .collect(Collectors.groupingBy(
                        String::length,
                        HashMap::new,
                        Collectors.toSet()
                ));


        assertEquals(3, result.get(2).size());
        assertTrue(result.get(2).contains("to"));
        assertTrue(result.get(2).contains("be"));
        assertTrue(result.get(2).contains("or"));
        assertEquals(1, result.get(3).size());
        assertTrue(result.get(3).contains("not"));

    }

    @Test
    void groupByListConcurrent() {

        ConcurrentMap<Integer, List<String>> result = createStream()
                .collect(Collectors.groupingByConcurrent(String::length));


        assertEquals(2, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "to", "be"},
                result.get(2).toArray(new String[]{})
        );
        assertArrayEquals(
                new String[]{"not"},
                result.get(3).toArray(new String[]{})
        );

    }

    @Test
    void groupBySetConcurrent() {

        ConcurrentMap<Integer, Set<String>> result = createStream()
                .collect(Collectors.groupingByConcurrent(
                        String::length,
                        Collectors.toSet()
                ));


        assertEquals(3, result.get(2).size());
        assertTrue(result.get(2).contains("to"));
        assertTrue(result.get(2).contains("be"));
        assertTrue(result.get(2).contains("or"));
        assertEquals(1, result.get(3).size());
        assertTrue(result.get(3).contains("not"));

    }

    @Test
    void groupBySetWithSupplierConcurrent() {

        ConcurrentMap<Integer, Set<String>> result = createStream()
                .collect(Collectors.groupingByConcurrent(
                        String::length,
                        ConcurrentHashMap::new,
                        Collectors.toSet()
                ));


        assertEquals(3, result.get(2).size());
        assertTrue(result.get(2).contains("to"));
        assertTrue(result.get(2).contains("be"));
        assertTrue(result.get(2).contains("or"));
        assertEquals(1, result.get(3).size());
        assertTrue(result.get(3).contains("not"));

    }
}
