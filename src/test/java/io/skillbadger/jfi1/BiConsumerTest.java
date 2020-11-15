package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiConsumerTest {

    @Test
    public void explicit() {
        BiConsumer<List<String>, String> biconsumer = new BiConsumer<List<String>, String>() {
            @Override
            public void accept(List<String> strings, String string) {
                strings.add(string);
            }
        };
        List<String> strings = new ArrayList<>();
        biconsumer.accept(strings, "hello");
        assertEquals("hello", strings.get(0));
    }

    @Test
    public void lambda() {
        BiConsumer<List<String>, String> biconsumer = (strings, string) -> strings.add(string);
        List<String> strings = new ArrayList<>();
        biconsumer.accept(strings, "hello");
        assertEquals("hello", strings.get(0));
    }

    @Test
    public void methodReference() {
        BiConsumer<List<String>, String> biconsumer = List::add;
        List<String> strings = new ArrayList<>();
        biconsumer.accept(strings, "hello");
        assertEquals("hello", strings.get(0));
    }

}
