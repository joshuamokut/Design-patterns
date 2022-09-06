package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.CeilingFan;
import SomeJava.CommandPattern.utility.Speed;

public class CeilingFanLowCommand implements Command {
    private final CeilingFan ceilingFan;
    private Speed previousSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
        previousSpeed = ceilingFan.getSpeed();
    }

    @Override
    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    @Override
    public void undo() {
        switch (previousSpeed) {
            case HIGH -> ceilingFan.high();
            case LOW -> ceilingFan.low();
            case MEDIUM -> ceilingFan.medium();
            case OFF -> ceilingFan.off();
            default -> {
            }
        }
    }
}

