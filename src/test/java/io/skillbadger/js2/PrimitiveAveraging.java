package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimitiveAveraging {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void intAverageLength() {

        double result = createStream()
                .collect(Collectors.averagingInt(this::intLength));


        assertTrue(2 < result);
        assertTrue(result < 3);

    }

    @Test
    void longAverageLength() {

        double result = createStream()
                .collect(Collectors.averagingLong(this::longLength));


        assertTrue(2 < result);
        assertTrue(result < 3);

    }

    @Test
    void doubleAverageLength() {

        double result = createStream()
                .collect(Collectors.averagingDouble(this::doubleLength));


        assertTrue(2 < result);
        assertTrue(result < 3);

    }

    @Test
    void allThatAveragingIntCanUse() {

        double byteResult = createStream()
                .collect(Collectors.averagingInt(this::byteLength));

        double shortResult = createStream()
                .collect(Collectors.averagingInt(this::shortLength));

        double intResult = createStream()
                .collect(Collectors.averagingInt(this::intLength));


        assertTrue(2 < byteResult);
        assertTrue(byteResult < 3);

        assertTrue(2 < shortResult);
        assertTrue(shortResult < 3);

        assertTrue(2 < intResult);
        assertTrue(intResult < 3);

    }

    @Test
    void allThatAveragingLongCanUse() {

        double byteResult = createStream()
                .collect(Collectors.averagingLong(this::byteLength));

        double shortResult = createStream()
                .collect(Collectors.averagingLong(this::shortLength));

        double intResult = createStream()
                .collect(Collectors.averagingLong(this::intLength));

        double longResult = createStream()
                .collect(Collectors.averagingLong(this::longLength));


        assertTrue(2 < byteResult);
        assertTrue(byteResult < 3);

        assertTrue(2 < shortResult);
        assertTrue(shortResult < 3);

        assertTrue(2 < intResult);
        assertTrue(intResult < 3);

        assertTrue(2 < longResult);
        assertTrue(longResult < 3);

    }

    @Test
    void allThatAveragingDoubleCanUse() {

        double byteResult = createStream()
                .collect(Collectors.averagingDouble(this::byteLength));

        double shortResult = createStream()
                .collect(Collectors.averagingDouble(this::shortLength));

        double intResult = createStream()
                .collect(Collectors.averagingDouble(this::intLength));

        double longResult = createStream()
                .collect(Collectors.averagingDouble(this::longLength));

        double floatResult = createStream()
                .collect(Collectors.averagingDouble(this::floatLength));

        double doubleResult = createStream()
                .collect(Collectors.averagingDouble(this::doubleLength));


        assertTrue(2 < byteResult);
        assertTrue(byteResult < 3);

        assertTrue(2 < shortResult);
        assertTrue(shortResult < 3);

        assertTrue(2 < intResult);
        assertTrue(intResult < 3);

        assertTrue(2 < longResult);
        assertTrue(longResult < 3);

        assertTrue(2 < floatResult);
        assertTrue(floatResult < 3);

        assertTrue(2 < doubleResult);
        assertTrue(doubleResult < 3);

    }

    private byte byteLength(String s) {
        return (byte) s.length();
    }

    private short shortLength(String s) {
        return (short) s.length();
    }

    private int intLength(String s) {
        return s.length();
    }

    private long longLength(String s) {
        return s.length();
    }

    private float floatLength(String s) {
        return s.length();
    }

    private double doubleLength(String s) {
        return s.length();
    }
}
