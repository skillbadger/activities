package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionOnPrimitiveTest {

    @Test
    void primitiveTypes() {

        IntUnaryOperator negate = operand -> -operand;

        IntUnaryOperator negateTwice = negate.andThen(negate);

        assertEquals(5, negateTwice.applyAsInt(5));

    }

}
