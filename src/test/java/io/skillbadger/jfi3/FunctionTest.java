package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

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

        Function<String, Integer> lengthOfString = toArray.andThen(arrayLength);

        assertEquals(5, lengthOfString.apply("hello"));

    }

    @Test
    void primitiveTypes() {

        IntUnaryOperator negate = operand -> -operand;

        IntUnaryOperator negateTwice = negate.andThen(negate);

        assertEquals(5, negateTwice.applyAsInt(5));

    }

}
