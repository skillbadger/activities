package io.skillbadger.js1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateStream {

    @Test
    void createStream() {

        List<String> listOfStrings = Arrays.asList("hello", "world");

        Stream<String> streamOfStrings = listOfStrings.stream();

        assertNotNull(streamOfStrings);

    }
}
