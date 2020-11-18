package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiPredicateTest {

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


}
