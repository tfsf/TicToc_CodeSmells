package command;

public class PlayerCommand implements EndCommand {
    @Override
    public String execute() {
        return "You Won";
    }
}
