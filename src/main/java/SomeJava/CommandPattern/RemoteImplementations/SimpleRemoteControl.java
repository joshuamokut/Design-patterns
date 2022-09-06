package SomeJava.CommandPattern.RemoteImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;

public class SimpleRemoteControl {
    private Command slot;

    public SimpleRemoteControl() {
    }

    public SimpleRemoteControl(Command command) {
        slot = command;
    }

    public void setSlot(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
