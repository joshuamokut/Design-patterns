package SomeJava.CommandPattern.Devices;

public class Light {
    private final String name;

    public Light(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}
