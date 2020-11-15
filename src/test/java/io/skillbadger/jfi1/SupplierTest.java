package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {

    @Test
    public void explicit() {
        Counter counter = new Counter();

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return counter.next();
            }
        };

        Integer firstResult = supplier.get();
        assertEquals(1, firstResult);

        Integer secondResult = supplier.get();
        assertEquals(2, secondResult);
    }

    @Test
    public void lambda() {
        Counter counter = new Counter();

        Supplier<Integer> supplier = () -> counter.next();

        Integer firstResult = supplier.get();
        assertEquals(1, firstResult);

        Integer secondResult = supplier.get();
        assertEquals(2, secondResult);
    }

    @Test
    public void methodReference() {
        Counter counter = new Counter();

        Supplier<Integer> supplier = counter::next;

        Integer firstResult = supplier.get();
        assertEquals(1, firstResult);

        Integer secondResult = supplier.get();
        assertEquals(2, secondResult);
    }

    private static class Counter {
        private int value;

        public Integer next() {
            return ++value;
        }
    }
}
