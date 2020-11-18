package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerOnPrimitiveTest {

    @Test
    void primitive() {

        int[] integers = new int[]{0};
        IntConsumer consumer1 = value -> integers[0] += value;
        IntConsumer consumer2 = value -> integers[0] *= value;

        IntConsumer chained = consumer1.andThen(consumer2);

        chained.accept(2);
        assertEquals(4, integers[0]);

    }


}
