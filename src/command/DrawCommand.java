package command;

public class DrawCommand implements EndCommand {
    @Override
    public String execute() {
        return "Draw";
    }
}
