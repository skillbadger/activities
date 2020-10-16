package io.skillbadger.javastreams.summer;

import io.skillbadger.javastreams.things.BarThing;
import io.skillbadger.javastreams.things.BigThing;
import io.skillbadger.javastreams.things.FooThing;

import java.util.List;

public class ClassicalThingsSummer implements ThingsSummer {

  @Override
  public Integer computeSum(BigThing[] bigThings) {
    Integer sum = 0;
    if (bigThings != null) {
      for (BigThing bigThing : bigThings) {
        if (bigThing != null) {
          BarThing[] barThings = bigThing.getBarThings();
          if (barThings != null) {
            for (BarThing barThing : barThings) {
              if (barThing != null) {
                Integer numberOfBars = barThing.getNumberOfBars();
                if (numberOfBars != null) {
                  sum += numberOfBars;
                }
              }
            }
          }
          List<FooThing> fooThings = bigThing.getFooThings();
          if (fooThings != null) {
            for (FooThing fooThing : fooThings) {
              if (fooThing != null) {
                Integer numberOfFoos = fooThing.getNumberOfFoos();
                if (numberOfFoos != null) {
                  sum += numberOfFoos;
                }
              }
            }
          }
        }
      }
    }
    return sum;
  }

}
