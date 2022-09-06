package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
