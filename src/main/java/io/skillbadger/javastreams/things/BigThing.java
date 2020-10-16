package io.skillbadger.javastreams.things;

import java.util.List;

public class BigThing {

  private List<FooThing> fooThings;
  private BarThing[] barThings;

  public List<FooThing> getFooThings() {
    return fooThings;
  }

  public void setFooThings(List<FooThing> fooThings) {
    this.fooThings = fooThings;
  }

  public BarThing[] getBarThings() {
    return barThings;
  }

  public void setBarThings(BarThing[] barThings) {
    this.barThings = barThings;
  }
}
