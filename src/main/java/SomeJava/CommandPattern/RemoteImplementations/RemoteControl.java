package SomeJava.CommandPattern.RemoteImplementations;

import SomeJava.CommandPattern.CommandImplementations.NoCommand;
import SomeJava.CommandPattern.CommandInterfaces.Command;

public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;
    private final int SLOT_COUNT = 7;

    public RemoteControl() {
        onCommands = new Command[SLOT_COUNT];
        offCommands = new Command[SLOT_COUNT];
        undoCommand = new NoCommand();

        Command noCommand = new NoCommand();
        for (int i = 0; i < SLOT_COUNT; i++) {
            onCommands[i] = offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----------Remote Control --------------\n");
        for (int i = 0; i < SLOT_COUNT; i++) {
            sb.append(String.format("Slot %d:    %-30s %-20s\n", i, onCommands[i].getClass().getSimpleName(),
                    offCommands[i].getClass().getSimpleName()));
        }

        return sb.toString();
    }
}
