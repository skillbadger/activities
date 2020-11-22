package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreatingMaps {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void toMapThrows() {

        assertThrows(
                IllegalStateException.class,
                () -> createStream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                String::length
                        ))
        );

    }

    @Test
    void toMapDistinct() {

        Map<String, Integer> result = createStream().distinct()
                .collect(Collectors.toMap(
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
    void toMapMerge() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toMap(
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
    void toMapMergeCount() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        s -> 1,
                        Integer::sum
                ));

        assertEquals(4, result.size());
        assertEquals(2, result.get("to"));
        assertEquals(2, result.get("be"));
        assertEquals(1, result.get("or"));
        assertEquals(1, result.get("not"));

    }

    @Test
    void toMapMergeWithMapFactory() {

        Map<String, Integer> result = createStream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        Integer::sum,
                        (Supplier<HashMap<String, Integer>>) HashMap::new
                ));

        assertEquals(4, result.size());
        assertEquals(4, result.get("to"));
        assertEquals(4, result.get("be"));
        assertEquals(2, result.get("or"));
        assertEquals(3, result.get("not"));

    }

}
