package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnmodifiableAndConcurrentMaps {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void toMapDistinctUnmodifiable() {

        Map<String, Integer> result = createStream()
                .distinct()
                .collect(Collectors.toUnmodifiableMap(
                        Function.identity(),
                        String::length
                ));

        assertEquals(4, result.size());
        assertEquals(2, result.get("to"));
        assertEquals(2, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

    @Test
    void toMapMergeUnmodifiable() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toUnmodifiableMap(
                        Function.identity(),
                        String::length,
                        Integer::sum
                ));

        assertEquals(4, result.size());
        assertEquals(4, result.get("to"));
        assertEquals(4, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

    @Test
    void toMapDistinctConcurrent() {

        Map<String, Integer> result = createStream()
                .distinct()
                .collect(Collectors.toConcurrentMap(
                        Function.identity(),
                        String::length
                ));

        assertEquals(4, result.size());
        assertEquals(2, result.get("to"));
        assertEquals(2, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

    @Test
    void toMapMergeConcurrent() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toConcurrentMap(
                        Function.identity(),
                        String::length,
                        Integer::sum
                ));

        assertEquals(4, result.size());
        assertEquals(4, result.get("to"));
        assertEquals(4, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

    @Test
    void toMapMergeWithMapFactoryConcurrent() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        Integer::sum,
                        (Supplier<ConcurrentHashMap<String, Integer>>) ConcurrentHashMap::new
                ));

        assertEquals(4, result.size());
        assertEquals(4, result.get("to"));
        assertEquals(4, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

}
