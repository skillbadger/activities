package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimitiveSummarizing {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void summarizingInt() {

        IntSummaryStatistics result = createStream()
                .collect(Collectors.summarizingInt(String::length));

        assertEquals(6, result.getCount());
        assertTrue(2 < result.getAverage());
        assertTrue(result.getAverage() < 3);
        assertEquals(2, result.getMin());
        assertEquals(3, result.getMax());
        assertEquals(13, result.getSum());


    }

    @Test
    void summarizingLong() {

        LongSummaryStatistics result = createStream()
                .collect(Collectors.summarizingLong(String::length));


        assertEquals(6, result.getCount());
        assertTrue(2 < result.getAverage());
        assertTrue(result.getAverage() < 3);
        assertEquals(2, result.getMin());
        assertEquals(3, result.getMax());
        assertEquals(13, result.getSum());


    }
    @Test
    void summarizingDouble() {

        DoubleSummaryStatistics result = createStream()
                .collect(Collectors.summarizingDouble(String::length));


        assertEquals(6, result.getCount());
        assertTrue(2 < result.getAverage());
        assertTrue(result.getAverage() < 3);
        assertEquals(2, result.getMin());
        assertEquals(3, result.getMax());
        assertEquals(13, result.getSum());


    }
}
