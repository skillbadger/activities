package io.skillbadger.jfi3;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerOnObjectTest {

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

}
