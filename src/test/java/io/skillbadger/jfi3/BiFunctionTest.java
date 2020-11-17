package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiFunctionTest {

    @Test
    void chainingABiFunction() {

        BiFunction<String, Charset, byte[]> getBytes = String::getBytes;
        Function<byte[], Integer> byteLength = bytes -> bytes.length;

        BiFunction<String, Charset, Integer> getByteLength = getBytes.andThen(byteLength);

        Integer result = getByteLength.apply("hello", StandardCharsets.UTF_8);
        assertEquals(5, result);
    }

}
