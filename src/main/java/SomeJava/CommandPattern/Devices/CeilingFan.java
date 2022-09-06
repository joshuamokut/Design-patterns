package SomeJava.CommandPattern.Devices;

import SomeJava.CommandPattern.utility.Speed;

public class CeilingFan {
    private final String name;

    private Speed speed;

    public CeilingFan(String name) {
        this.name = name;
        this.speed = Speed.OFF;
    }

    public void high() {
        System.out.println("Fan is now on high");
        speed = Speed.HIGH;
    }

    public void low() {
        speed = Speed.LOW;
        System.out.println("Fan is now on low");
    }

    public void medium() {
        speed = Speed.MEDIUM;
        System.out.println("Fan is now on medium");
    }

    public void off() {
        speed = Speed.OFF;
        System.out.println("Fan is now off");
    }

    public Speed getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
