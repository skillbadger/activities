package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryOperatorTest {

    @Test
    public void explicit() {
        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1.concat(s2);
            }
        };
        String result = binaryOperator.apply("x", "y");
        assertEquals("xy", result);
    }

    @Test
    public void lambda() {
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        String result = binaryOperator.apply("x", "y");
        assertEquals("xy", result);
    }

    @Test
    public void methodReference() {
        BinaryOperator<String> binaryOperator = String::concat;
        String result = binaryOperator.apply("x", "y");
        assertEquals("xy", result);
    }
}
