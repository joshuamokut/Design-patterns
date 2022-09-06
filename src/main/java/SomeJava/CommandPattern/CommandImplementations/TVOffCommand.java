package SomeJava.CommandPattern.CommandImplementations;

import SomeJava.CommandPattern.CommandInterfaces.Command;
import SomeJava.CommandPattern.Devices.TV;

public class TVOffCommand implements Command {
    private final TV tv;
    private int previousVolume;
    private String previousInputChannel;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        previousVolume = tv.getVolume();
        previousInputChannel = tv.getInputChannel();
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
        tv.setInputChannel(previousInputChannel);
        tv.setVolume(previousVolume);
    }
}
