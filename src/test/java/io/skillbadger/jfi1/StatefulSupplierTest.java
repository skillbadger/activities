package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatefulSupplierTest {

    @Test
    public void explicit() {
        
        Supplier<Integer> supplier = new Supplier<Integer>() {

            private int value;

            @Override
            public Integer get() {
                return ++value;
            }
        };

        Integer firstResult = supplier.get();
        assertEquals(1, firstResult);

        Integer secondResult = supplier.get();
        assertEquals(2, secondResult);
    }

    @Test
    public void lambda() {

        int[] v = new int[]{0};
        Supplier<Integer> supplier = () -> ++v[0];

        Integer firstResult = supplier.get();
        assertEquals(1, firstResult);

        Integer secondResult = supplier.get();
        assertEquals(2, secondResult);
    }
}
