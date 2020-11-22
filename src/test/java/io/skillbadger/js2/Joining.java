package io.skillbadger.js2;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Joining {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    @Test
    void joining() {

        String result = createStream()
                .collect(Collectors.joining());

        assertEquals("tobeornottobe", result);

    }

    @Test
    void joiningSpaceSeparated() {

        String result = createStream()
                .collect(Collectors.joining(" "));

        assertEquals("to be or not to be", result);

    }

    @Test
    void joiningSpaceSepararatedInBrackets() {

        String result = createStream()
                .collect(Collectors.joining(" ", "[", "]"));

        assertEquals("[to be or not to be]", result);
    }


}
