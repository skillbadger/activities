package io.skillbadger.jfi2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntToLongFunction;

class FunctionsConvertingPrimitiveTypeTest {

    @Test
    void explicitFunction() {

        IntToLongFunction function = new IntToLongFunction() {
            @Override
            public long applyAsLong(int value) {
                return value;
            }
        };

        int value = 0;
        long expectedResult = 0L;

        long result = function.applyAsLong(value);
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void lambdaFunction() {

        IntToLongFunction function = value -> value;

        int value = 0;
        long expectedResult = 0L;

        long result = function.applyAsLong(value);
        Assertions.assertEquals(expectedResult, result);
    }

}
