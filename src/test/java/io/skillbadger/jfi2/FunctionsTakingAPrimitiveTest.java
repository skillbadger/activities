package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTakingAPrimitiveTest {

    @Test
    void explicitFunction() {

        IntFunction<String> function = new IntFunction<String>() {
            @Override
            public String apply(int value) {
                return Integer.toString(value);
            }
        };

        String result = function.apply(0);
        assertEquals("0", result);

    }

    @Test
    void lambdaFunction() {

        IntFunction<String> function = value -> Integer.toString(value);

        String result = function.apply(0);
        assertEquals("0", result);

    }

    @Test
    void methodReferenceFunction() {

        IntFunction<String> function = Integer::toString;

        String result = function.apply(0);
        assertEquals("0", result);

    }

}
