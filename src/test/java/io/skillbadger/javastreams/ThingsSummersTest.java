package io.skillbadger.javastreams;

import io.skillbadger.javastreams.summer.StreamThingsSummer;
import io.skillbadger.javastreams.summer.ClassicalThingsSummer;
import io.skillbadger.javastreams.summer.ThingsSummer;
import io.skillbadger.javastreams.things.BarThing;
import io.skillbadger.javastreams.things.BigThing;
import io.skillbadger.javastreams.things.FooThing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class ThingsSummersTest {

  @Test
  void test() {
    for (TestCase testCase : getTestCases()) {
      for (ThingsSummer summer : getSummers()) {
        assertEquals(testCase.getExpectedSum(), summer.computeSum(testCase.getBigThings()));
      }
    }
  }

  private static TestCase[] getTestCases() {
    return new TestCase[] {
        new TestCase(getBigThings(false, false), 0),
        new TestCase(getBigThings(true, false), 0),
        new TestCase(getBigThings(true, true), 2),
    };
  }

  private static class TestCase {
    private final BigThing[] bigThings;
    private final int expectedSum;

    public TestCase(BigThing[] bigThings, int expectedSum) {
      this.bigThings = bigThings;
      this.expectedSum = expectedSum;
    }

    public BigThing[] getBigThings() {
      return bigThings;
    }

    public int getExpectedSum() {
      return expectedSum;
    }
  }

  private static ThingsSummer[] getSummers() {
    return new ThingsSummer[] {
        new ClassicalThingsSummer(),
        new StreamThingsSummer()
    };
  }

  private static BigThing[] getBigThings(boolean nonnull, boolean notempty) {
    BigThing[] bigThings = null;
    if (nonnull) {

      if (notempty) {

        BarThing barThing1 = new BarThing();
        barThing1.setNumberOfBars(1);

        BarThing barThing2 = new BarThing();

        BarThing[] barThings1 = new BarThing[] { barThing1, null, barThing2 };

        FooThing fooThing1 = new FooThing();
        fooThing1.setNumberOfFoos(1);

        FooThing fooThing2 = new FooThing();

        List<FooThing> fooThings1 = new ArrayList<>();
        fooThings1.add(fooThing1);
        fooThings1.add(null);
        fooThings1.add(fooThing2);

        BigThing bigThing1 = new BigThing();
        bigThing1.setFooThings(fooThings1);
        bigThing1.setBarThings(barThings1);

        BigThing bigThing2 = new BigThing();

        bigThings = new BigThing[] { bigThing1, bigThing2, null };

      } else {
        bigThings = new BigThing[] {};
      }
    }
    return bigThings;
  }

}
