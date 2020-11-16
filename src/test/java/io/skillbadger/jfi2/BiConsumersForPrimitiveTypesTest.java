package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.ObjIntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BiConsumersForPrimitiveTypesTest {

    @Test
    void explicitBiFunction() {

        String[] consumed = new String[]{null};

        ObjIntConsumer<String> consumer = new ObjIntConsumer<String>() {
            @Override
            public void accept(String string, int value) {
                consumed[0] = string.substring(value);
            }
        };

        consumer.accept("hello", 3);

        String result = consumed[0];
        assertEquals("lo", result);

    }

    @Test
    void lambdaBiFunction() {

        String[] consumed = new String[]{null};

        ObjIntConsumer<String> consumer = (string, value) -> consumed[0] = string.substring(value);

        consumer.accept("hello", 3);

        String result = consumed[0];
        assertEquals("lo", result);

    }
    
}
