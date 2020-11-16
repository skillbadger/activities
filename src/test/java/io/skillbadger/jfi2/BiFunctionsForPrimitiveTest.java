package io.skillbadger.jfi2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.ToIntBiFunction;

class BiFunctionsForPrimitiveTest {

    @Test
    void explicitBiFunction() {

        ToIntBiFunction<String, Charset> biFunction = new ToIntBiFunction<String, Charset>() {
            @Override
            public int applyAsInt(String s, Charset charset) {
                return s.getBytes(charset).length;
            }
        };

        int result = biFunction.applyAsInt("hello", StandardCharsets.UTF_8);
        Assertions.assertEquals(5, result);
    }

    @Test
    void lambdaBiFunction() {

        ToIntBiFunction<String, Charset> biFunction = (s, charset) -> s.getBytes(charset).length;

        int result = biFunction.applyAsInt("hello", StandardCharsets.UTF_8);
        Assertions.assertEquals(5, result);
    }
    
}
