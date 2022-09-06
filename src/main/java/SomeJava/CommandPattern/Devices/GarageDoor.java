package SomeJava.CommandPattern.Devices;

public class GarageDoor {

    private final String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void up() {
        System.out.println("garage door is open");
    }

    public void down() {
        System.out.println("garage door is closed");
    }

    public void stop() {
        System.out.println("Garage door has stopped");
    }

    public void lightOn() {
        System.out.println("Garage door light is now on");
    }

    public void lightOff() {
        System.out.println("Garage door light is now off");
    }
}
