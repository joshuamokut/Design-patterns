package SomeJava.CommandPattern.Devices;

public class TV {
    private final String location;
    private int volume;
    private boolean power;
    private String inputChannel;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.printf("TV in the %s is now on%n", location);
        power = true;
    }

    public void off() {
        System.out.printf("TV in the %s is now off%n", location);
        power = false;
    }


    public void setVolume(Integer volume) {
        System.out.printf("volume for TV in the %s is now set to %d%n", location, volume);
        this.volume = volume;
    }

    public void setInputChannel(String inputChannel) {
        System.out.printf("input channel for TV in the %s is now set to %s%n", location, inputChannel);
        this.inputChannel = inputChannel;
    }

    public int getVolume() {
        return volume;
    }

    public String getInputChannel() {
        return inputChannel;
    }

    public boolean isPower() {
        return power;
    }

    public String getLocation() {
        return location;
    }
}
