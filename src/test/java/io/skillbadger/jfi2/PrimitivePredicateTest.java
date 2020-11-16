package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimitivePredicateTest {

    @Test
    void explicitPredicate() {

        IntPredicate predicate = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value == 0;
            }
        };

        boolean positiveResult = predicate.test(0);
        assertTrue(positiveResult);

        boolean negativeResult = predicate.test(1);
        assertFalse(negativeResult);

    }

    @Test
    void lambdaPredicate() {

        IntPredicate predicate = value -> value == 0;

        boolean positiveResult = predicate.test(0);
        assertTrue(positiveResult);

        boolean negativeResult = predicate.test(1);
        assertFalse(negativeResult);

    }

}
