package SomeJava.AdapterPattern.Adapters;

import SomeJava.AdapterPattern.Interaces.Duck;
import SomeJava.AdapterPattern.Interaces.Turkey;

public class TurkeyDuckAdapter implements Duck {
    private final Turkey turkey;

    public TurkeyDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
