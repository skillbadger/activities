package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsReturningAPrimitiveTypeTest {

    @Test
    void explicitFunction() {

        ToIntFunction<String> function = new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        };

        int result = function.applyAsInt("01");
        assertEquals(1, result);

    }

    @Test
    void lambdaFunction() {

        ToIntFunction<String> function = value -> Integer.parseInt(value);

        int result = function.applyAsInt("01");
        assertEquals(1, result);

    }

    @Test
    void methodReferenceFunction() {

        ToIntFunction<String> function = Integer::parseInt;

        int result = function.applyAsInt("01");
        assertEquals(1, result);

    }

}
