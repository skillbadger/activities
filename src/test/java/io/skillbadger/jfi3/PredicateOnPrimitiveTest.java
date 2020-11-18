package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateOnPrimitiveTest {

    @Test
    void primitiveTypes() {

        IntPredicate greaterThan12 = value -> value > 12;
        IntPredicate lessThan24 = value -> value < 24;

        IntPredicate between = greaterThan12.and(lessThan24);

        assertTrue(between.test(15));
        assertFalse(between.test(5));
        assertFalse(between.test(25));

    }

}
