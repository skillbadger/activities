package io.skillbadger.js2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teeing {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void collectingAndThen() {

        String result = createStream()
                .collect(Collectors.teeing(
                        Collectors.minBy(String::compareTo),
                        Collectors.maxBy(String::compareTo),
                        (l, s) -> l.orElse("?") + " " + s.orElse("?"))
                );
        Assertions.assertEquals("be to", result);


    }


}
