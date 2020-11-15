package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnaryOperatorTest {

    @Test
    public void explicit() {
        UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String unaryT) {
                return unaryT.toUpperCase();
            }
        };
        String result = unaryOperator.apply("hello");
        assertEquals("HELLO", result);
    }

    @Test
    public void lambda() {
        UnaryOperator<String> unaryOperator = unaryT -> unaryT.toUpperCase();
        String result = unaryOperator.apply("hello");
        assertEquals("HELLO", result);
    }

    @Test
    public void methodReference() {
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        String result = unaryOperator.apply("hello");
        assertEquals("HELLO", result);
    }
}
