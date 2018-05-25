package command;

public class CommandManager {
    EndCommand[] endCommands;

    public CommandManager() {
        endCommands = new EndCommand[]{new DrawCommand(), new PlayerCommand(), new CPUCommand()};
    }

    public String end(int i) {
        return endCommands[i].execute();
    }
}
