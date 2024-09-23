package behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class SpaceStationCommandDispatcher {
    private List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }
}
