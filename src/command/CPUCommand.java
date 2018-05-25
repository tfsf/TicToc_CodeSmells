package command;

public class CPUCommand implements EndCommand {

    @Override
    public String execute() {
        return "Computer Won";
    }
}
