package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class StaticMembersTest {

    @Test
    void identityFunction() {

        String result = Function.<String>identity().apply("hello");

        assertEquals("hello", result);

    }

    @Test
    void identityFunction2() {

        Function<String, String> idf = Function.identity();

        String result = idf.apply("hello");
        assertEquals("hello", result);

    }

    @Test
    void maxBy() {

        BinaryOperator<CharSequence> b = BinaryOperator.maxBy(CharSequence::compare);
        CharSequence result = b.apply("hello", "world");
        assertEquals("world", result);

    }

    @Test
    void equality() {

        String hello = "hello";
        Predicate<String> isEqualToHello = Predicate.isEqual(hello);
        assertTrue(isEqualToHello.test("hello"));
        assertFalse(isEqualToHello.test("world"));

    }

    @Test
    void negation() {

        Predicate<String> isNull = Objects::isNull;

        Predicate<String> isNotNull = Predicate.not(isNull);

        assertTrue(isNotNull.test("hello"));
        assertFalse(isNotNull.test(null));

    }

}
