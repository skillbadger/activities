package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimitiveConsumerTest {

    @Test
    void explicitConsumer() {

        int[] consumed = new int[]{0};

        IntConsumer consumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                consumed[0] = value;
            }
        };

        consumer.accept(1);

        assertEquals(1, consumed[0]);

    }

    @Test
    void lambdaConsumer() {

        int[] consumed = new int[]{0};

        IntConsumer lambdaConsumer = value -> consumed[0] = value;

        lambdaConsumer.accept(1);

        assertEquals(1, consumed[0]);

    }

}
