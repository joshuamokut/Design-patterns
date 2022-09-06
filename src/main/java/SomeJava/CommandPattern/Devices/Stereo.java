package SomeJava.CommandPattern.Devices;

public class Stereo {
    private int volume;
    private final String name;

    public Stereo(String name) {
        volume = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void on() {
        System.out.println("Stereo is now on");
    }

    public void off() {

    }

    public void setCd() {
        System.out.println("CD is now set");
    }

    public void setDvd() {
        System.out.println("DVD is now set");
    }

    public void setRadio() {
        System.out.println("Radio is now set");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.printf("Volume is not at %d%n", volume);
    }
}
