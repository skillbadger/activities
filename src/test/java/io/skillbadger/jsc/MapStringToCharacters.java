package io.skillbadger.jsc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapStringToCharacters {

    private static Stream<String> createStream() {
        return Stream.of("to", "be", "or", "not", "to", "be");
    }

    /* Challenge: count the characters in a stream of string */
    @Test
    void stringToChars() {

        Map<Character, Integer> result = createStream().flatMap(s -> {
            final char[] chars = s.toCharArray();
            return Stream.generate(new Supplier<Character>() {
                private int i;

                @Override
                public Character get() {
                    return i < chars.length ? chars[i++] : null;
                }
            }).limit(chars.length);
        }).collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));

        assertEquals(6, result.size());
        assertEquals(2, result.get('b'));
        assertEquals(2, result.get('e'));
        assertEquals(1, result.get('n'));
        assertEquals(4, result.get('o'));
        assertEquals(1, result.get('r'));
        assertEquals(3, result.get('t'));

    }


}
