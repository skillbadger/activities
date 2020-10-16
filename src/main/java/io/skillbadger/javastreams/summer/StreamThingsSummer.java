package io.skillbadger.javastreams.summer;

import io.skillbadger.javastreams.things.BarThing;
import io.skillbadger.javastreams.things.BigThing;
import io.skillbadger.javastreams.things.FooThing;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class StreamThingsSummer implements ThingsSummer {

  @Override
  public Integer computeSum(BigThing[] bigThings) {
    return Optional.ofNullable(bigThings)
        .map(nonNullBigThings -> Arrays.stream(nonNullBigThings)
            .filter(Objects::nonNull)
            .map(bigThing -> Optional.ofNullable(bigThing.getBarThings())
                .map(barThings -> Arrays.stream(barThings)
                    .filter(Objects::nonNull)
                    .map(BarThing::getNumberOfBars)
                    .filter(Objects::nonNull)
                    .reduce(Integer::sum)
                    .orElse(0))
                .orElse(0)
                + Optional.ofNullable(bigThing.getFooThings())
                    .map(fooThings -> fooThings.stream()
                        .filter(Objects::nonNull)
                        .map(FooThing::getNumberOfFoos)
                        .filter(Objects::nonNull)
                        .reduce(Integer::sum)
                        .orElse(0))
                    .orElse(0))
            .reduce(Integer::sum)
            .orElse(0))
        .orElse(0);
  }
}
