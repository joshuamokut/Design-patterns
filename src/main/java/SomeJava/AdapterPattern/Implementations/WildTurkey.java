package SomeJava.AdapterPattern.Implementations;

import SomeJava.AdapterPattern.Interaces.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance. I'm too heavy");
    }
}
