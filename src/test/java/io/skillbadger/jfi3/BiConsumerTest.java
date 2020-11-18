package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiConsumerTest {

    @Test
    void biConsumers() {

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> putInMap = map::put;
        BiConsumer<String, Integer> triple = (s, integer) -> {
            Integer value = map.getOrDefault(s, 0);
            map.put(s, value * 3);
        };

        BiConsumer<String, Integer> putTriple = putInMap.andThen(triple);

        putTriple.accept("hello", 5);
        assertEquals(15, map.get("hello"));

    }

}
