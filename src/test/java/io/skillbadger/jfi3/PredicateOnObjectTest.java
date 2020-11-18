package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateOnObjectTest {

    @Test
    void nonNullAndNotEmpty() {

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> isNonNullAndNotEmpty = nonNull.and(isEmpty.negate());

        assertTrue(isNonNullAndNotEmpty.test("hello"));
        assertFalse(isNonNullAndNotEmpty.test(""));
        assertFalse(isNonNullAndNotEmpty.test(null));

    }

    @Test
    void nullOrEmpty() {

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        assertFalse(isNullOrEmpty.test("hello"));
        assertTrue(isNullOrEmpty.test(""));
        assertTrue(isNullOrEmpty.test(null));

    }

    @Test
    void differentTypes() {

        Predicate<Integer> greaterThan2 = integer -> integer > 2;
        Predicate<Number> smallEnough = number -> number.longValue() == number.shortValue();

        Predicate<Integer> smallEnoughAndGreaterThan2 = greaterThan2.and(smallEnough);

        assertTrue(smallEnoughAndGreaterThan2.test(5));
        assertFalse(smallEnoughAndGreaterThan2.test(1));
        assertFalse(smallEnoughAndGreaterThan2.test(Integer.MAX_VALUE));

    }

}
