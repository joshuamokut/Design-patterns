package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.HotTub;

public class HotTubOffCommand implements Command {
    private final HotTub hotTub;
    private double previousTemperature;

    public HotTubOffCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        previousTemperature = hotTub.getTemperature();
        hotTub.jetsOff();
    }

    @Override
    public void undo() {
        hotTub.jetsOn();
        hotTub.setTemperature(previousTemperature);
    }
}
