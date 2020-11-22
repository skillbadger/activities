package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Partition {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void partitionList() {

        Map<Boolean, List<String>> result = createStream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() == 2
                ));


        assertEquals(2, result.size());
        assertArrayEquals(
                new String[]{"to", "be", "or", "to", "be"},
                result.get(true).toArray(new String[]{})
        );
        assertArrayEquals(
                new String[]{"not"},
                result.get(false).toArray(new String[]{})
        );

    }

    @Test
    void partitionSet() {

        Map<Boolean, Set<String>> result = createStream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() == 2,
                        Collectors.toSet()
                ));


        assertEquals(2, result.size());
        assertEquals(1, result.get(false).size());
        assertTrue(result.get(false).contains("not"));
        assertEquals(3, result.get(true).size());
        assertTrue(result.get(true).contains("to"));
        assertTrue(result.get(true).contains("be"));
        assertTrue(result.get(true).contains("or"));

    }

    @Test
    void partitionJoining() {

        Map<Boolean, String> result = createStream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() == 2,
                        Collectors.joining(",")
                ));


        assertEquals(2, result.size());
        assertEquals("not", result.get(false));
        assertEquals("to,be,or,to,be", result.get(true));

    }

}
