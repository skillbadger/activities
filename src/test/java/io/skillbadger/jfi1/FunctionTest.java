package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    @Test
    public void explicit() {
        Function<String, Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };
        Integer result = f.apply("hello");
        assertEquals(5, result);
    }

    @Test
    public void lambda() {
        Function<String, Integer> f = string -> string.length();
        Integer result = f.apply("hello");
        assertEquals(5, result);
    }

    @Test
    public void methodReference() {
        Function<String, Integer> f = string -> string.length();
        Integer result = f.apply("hello");
        assertEquals(5, result);
    }
}
