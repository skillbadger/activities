package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    @Test
    void sameType() {

        String[] strings = new String[]{null};
        Consumer<String> recordString = string -> strings[0] = string;
        Consumer<String> capitalize = s -> strings[0] = strings[0].toUpperCase();
        Consumer<String> recordCapitalizedString = recordString.andThen(capitalize);
        recordCapitalizedString.accept("hello");
        assertEquals("HELLO", strings[0]);

    }

    @Test
    void differentTypes() {

        Number[] numbers = new Number[]{0};
        Consumer<Integer> sumInteger = integer -> numbers[0] = numbers[0].intValue() + integer;
        Consumer<Number> sumNumberByte = number -> numbers[0] = numbers[0].byteValue() + number.byteValue();

        Consumer<Integer> integerThenNumber = sumInteger.andThen(sumNumberByte);

        integerThenNumber.accept(150);
        assertEquals(-212, numbers[0]);

    }

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

    @Test
    void primitive() {

        int[] integers = new int[]{0};
        IntConsumer consumer1 = value -> integers[0] += value;
        IntConsumer consumer2 = value -> integers[0] *= value;

        IntConsumer chained = consumer1.andThen(consumer2);

        chained.accept(2);
        assertEquals(4,integers[0]);

    }


}
