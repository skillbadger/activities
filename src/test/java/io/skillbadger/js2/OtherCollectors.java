package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherCollectors {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void mappingCollector() {

        Set<String> resultWithCollector = createStream()
                .collect(Collectors.mapping(
                        String::toUpperCase,
                        Collectors.toSet()
                ));

        Set<String> resultWithStream = createStream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        Consumer<Set<String>> verify = result -> {
            assertEquals(4, result.size());
            assertTrue(result.contains("TO"));
            assertTrue(result.contains("BE"));
            assertTrue(result.contains("OR"));
            assertTrue(result.contains("NOT"));
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);
    }

    @Test
    void minString() {

        Optional<String> resultWithCollector = createStream()
                .collect(Collectors.minBy(String::compareTo));

        Optional<String> resultWithStream = createStream()
                .min(String::compareTo);

        Consumer<Optional<String>> verify = result -> {
            assertTrue(result.isPresent());
            assertEquals("be", result.get());
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void maxString() {

        Optional<String> resultWithCollector = createStream()
                .collect(Collectors.maxBy(String::compareTo));

        Optional<String> resultWithStream = createStream()
                .max(String::compareTo);

        Consumer<Optional<String>> verify = result -> {
            assertTrue(result.isPresent());
            assertEquals("to", result.get());
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);


    }

    @Test
    void collectingAndThen() {

        Integer resultWithCollector = createStream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),
                        Set::size
                ));

        Integer resultWithStream = createStream()
                .collect(Collectors.toSet())
                .size();

        Consumer<Integer> verify = result -> {
            assertEquals(4, result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void flatMapping() {

        List<String> resultWithCollector = createStream()
                .collect(Collectors.flatMapping(
                        s -> Stream.of(s, Integer.toString(s.length())),
                        Collectors.toList())
                );

        List<String> resultWithStream = createStream()
                .flatMap(s -> Stream.of(s, Integer.toString(s.length())))
                .collect(Collectors.toList());


        Consumer<List<String>> verify = result -> {
            assertArrayEquals(
                    new String[]{"to", "2", "be", "2", "or", "2", "not", "3", "to", "2", "be", "2"},
                    result.toArray()
            );
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void filtering() {

        Set<String> resultWithCollector = createStream()
                .collect(Collectors.filtering(
                        s -> s.length() == 2,
                        Collectors.toSet()
                ));

        Set<String> resultWithStream = createStream()
                .filter(s -> s.length() == 2)
                .collect(Collectors.toSet());

        Consumer<Set<String>> verify = result -> {
            assertEquals(3, result.size());
            assertTrue(result.contains("to"));
            assertTrue(result.contains("be"));
            assertTrue(result.contains("or"));
            assertFalse(result.contains("not"));
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void reducing() {

        Optional<String> resultWithCollector = createStream()
                .collect(Collectors.reducing(String::concat));

        Optional<String> resultWithStream = createStream()
                .reduce(String::concat);

        Consumer<Optional<String>> verify = result -> {
            assertTrue(result.isPresent());
            assertEquals("tobeornottobe", result.get());
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void reducingWithIdentity() {

        String resultWithCollector = createStream()
                .collect(Collectors.reducing("", String::concat));

        String resultWithStream = createStream()
                .reduce("", String::concat);

        Consumer<String> verify = result -> {
            assertEquals("tobeornottobe", result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void reducingWithIdentityAndMapper() {

        String resultWithCollector = createStream()
                .collect(Collectors.reducing(
                        "",
                        String::toUpperCase,
                        String::concat
                ));

        String resultWithStream = createStream()
                .reduce(
                        "",
                        (s1, s2) -> s1 + s2.toUpperCase(),
                        String::concat
                );

        Consumer<String> verify = result -> {
            assertEquals("TOBEORNOTTOBE", result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void counting() {

        Long resultWithCollector = createStream()
                .collect(Collectors.counting());

        Long resultWithStream = createStream()
                .count();

        Consumer<Long> verify = result -> {
            assertEquals(6, result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);
    }

    @Test
    void intSum() {

        int resultWithCollector = createStream()
                .collect(Collectors.summingInt(String::length));

        int resultWithStream = createStream()
                .mapToInt(String::length)
                .sum();

        IntConsumer verify = result -> {
            assertEquals(13, result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void longSum() {

        long resultWithCollector = createStream()
                .collect(Collectors.summingLong(String::length));

        long resultWithStream = createStream()
                .mapToLong(String::length)
                .sum();


        LongConsumer verify = result -> {
            assertEquals(13, result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }

    @Test
    void doubleSum() {

        double resultWithCollector = createStream()
                .collect(Collectors.summingDouble(String::length));

        double resultWithStream = createStream()
                .mapToDouble(String::length)
                .sum();

        DoubleConsumer verify = result -> {
            assertEquals(13, result);
        };

        verify.accept(resultWithCollector);
        verify.accept(resultWithStream);

    }
}
