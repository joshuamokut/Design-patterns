package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;

public class NoCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {

    }
}
