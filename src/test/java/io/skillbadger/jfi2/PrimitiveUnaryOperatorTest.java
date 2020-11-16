package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimitiveUnaryOperatorTest {

    @Test
    void explicitUnaryOperator() {

        IntUnaryOperator unaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand + 1;
            }
        };

        int result = unaryOperator.applyAsInt(0);
        assertEquals(1, result);

    }

    @Test
    void lambdaUnaryOperator() {

        IntUnaryOperator unaryOperator = operand -> operand + 1;

        int result = unaryOperator.applyAsInt(0);
        assertEquals(1, result);

    }

}
