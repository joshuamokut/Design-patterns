package SomeJava.AdapterPattern.Adapters;

import SomeJava.AdapterPattern.Interaces.Duck;
import SomeJava.AdapterPattern.Interaces.Turkey;

public class DuckTurkeyAdapter implements Turkey {
    private final Duck duck;

    public DuckTurkeyAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
     }
}
