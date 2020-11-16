package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimitiveBinaryOperatorTest {

    @Test
    void explicitBinaryOperator() {

        IntBinaryOperator binaryOperator = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        };

        int result = binaryOperator.applyAsInt(1, 2);
        assertEquals(3, result);

    }

    @Test
    void lambdaBinaryOperator() {

        IntBinaryOperator binaryOperator = (left, right) -> left + right;

        int result = binaryOperator.applyAsInt(1, 2);
        assertEquals(3, result);

    }

    @Test
    void methodReferenceBinaryOperator() {

        IntBinaryOperator binaryOperator = Integer::sum;

        int result = binaryOperator.applyAsInt(1, 2);
        assertEquals(3, result);

    }

}
