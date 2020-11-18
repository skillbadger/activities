package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionOnObjectTest {

    @Test
    void sameObjectType() {

        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> greet = s -> "Hello " + s;

        Function<String, String> toUpperCaseAndThenGreet = toUpperCase.andThen(greet);
        assertEquals("Hello JOHN", toUpperCaseAndThenGreet.apply("john"));

        Function<String, String> composed = toUpperCase.compose(greet);
        assertEquals("HELLO JOHN", composed.apply("john"));

    }

    @Test
    void differentObjectTypes() {

        Function<String, char[]> toArray = String::toCharArray;
        Function<char[], Integer> arrayLength = chars -> chars.length;

        Function<String, Integer> lengthOfStringChained = toArray.andThen(arrayLength);
        assertEquals(5, lengthOfStringChained.apply("hello"));

        Function<String, Integer> lengthOfStringComposed = arrayLength.compose(toArray);
        assertEquals(5, lengthOfStringComposed.apply("hello"));

    }

}
