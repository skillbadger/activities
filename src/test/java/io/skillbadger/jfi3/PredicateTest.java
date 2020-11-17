package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

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
    void nullOrEmpty2() {

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNonNullAndNotEmpty = nonNull.and(isEmpty.negate());

        Predicate<String> isNullOrEmpty2 = isNonNullAndNotEmpty.negate();
        assertFalse(isNullOrEmpty2.test("hello"));
        assertTrue(isNullOrEmpty2.test(""));
        assertTrue(isNullOrEmpty2.test(null));
    }

    @Test
    void bipredicates() {

        BiPredicate<String, Integer> stringRepresentation = (s, integer) -> {
            if (s == null || integer == null) {
                return false;
            }
            return s.equals(integer.toString());
        };

        BiPredicate<String, Integer> greaterThan10 = (s, integer) -> integer != null && integer > 10;

        BiPredicate<String, Integer> combined = stringRepresentation.and(greaterThan10);

        assertTrue(combined.test("11", 11));
        assertFalse(combined.test("12", 11));
        assertFalse(combined.test("9", 9));
    }

    @Test
    void primitiveTypes() {

        IntPredicate greaterThan12 = value -> value > 12;
        IntPredicate lessThan24 = value -> value < 24;

        IntPredicate between = greaterThan12.and(lessThan24);

        assertTrue(between.test(15));
        assertFalse(between.test(5));
        assertFalse(between.test(25));

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
