package SomeJava.CommandPattern.Devices;

public class HotTub {
    private double temperature;

    public HotTub() {
        temperature = 27.0;
    }

    public void circulate() {
        System.out.println("Hot tub is now Circulating...");
    }

    public void jetsOn() {
        System.out.println("Hot tub Jets are now on...");
    }

    public void jetsOff() {
        System.out.println("Hot tub Jets are now off...");
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.printf("Temperature is now set to %.2f%n", temperature);
    }
}
