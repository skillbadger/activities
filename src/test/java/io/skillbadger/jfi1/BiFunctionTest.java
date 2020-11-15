package io.skillbadger.jfi1;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiFunctionTest {

    @Test
    public void explicit() {
        BiFunction<String, Integer, Person> bifunction =
                new BiFunction<String, Integer, Person>() {
                    @Override
                    public Person apply(String name, Integer age) {
                        return new Person(name, age);
                    }
                };
        Person result = bifunction.apply("john", 21);
        assertEquals("john", result.getName());
        assertEquals(21, result.getAge());
    }

    @Test
    public void lambda() {
        BiFunction<String, Integer, Person> bifunction = (name, age) -> new Person(name, age);
        Person result = bifunction.apply("john", 21);
        assertEquals("john", result.getName());
        assertEquals(21, result.getAge());
    }

    @Test
    public void methodReference() {
        BiFunction<String, Integer, Person> bifunction = Person::new;
        Person result = bifunction.apply("john", 21);
        assertEquals("john", result.getName());
        assertEquals(21, result.getAge());
    }

    private static class Person {

        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
