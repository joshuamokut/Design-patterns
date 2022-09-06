package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.HotTub;

public class HottubOnCommand implements Command {
    private final HotTub hotTub;
    private double previousTemperature;

    public HottubOnCommand(HotTub hotTub) {
        this.hotTub = hotTub;
        previousTemperature = hotTub.getTemperature();
    }

    @Override
    public void execute() {
        hotTub.jetsOn();
        previousTemperature = hotTub.getTemperature();
        hotTub.setTemperature(40);
    }

    @Override
    public void undo() {
        hotTub.setTemperature(previousTemperature);
        hotTub.jetsOff();
    }
}
