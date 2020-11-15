package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    @Test
    public void explicit() {
        List<String> strings = new ArrayList<>();
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String string) {
                strings.add(string);
            }
        };
        consumer.accept("hello");
        assertEquals("hello", strings.get(0));
    }

    @Test
    public void lambda() {
        List<String> strings = new ArrayList<>();
        Consumer<String> consumer = string -> strings.add(string);
        consumer.accept("hello");
        assertEquals("hello", strings.get(0));
    }

    @Test
    public void methodReference() {
        List<String> strings = new ArrayList<>();
        Consumer<String> consumer = strings::add;
        consumer.accept("hello");
        assertEquals("hello", strings.get(0));
    }
}
