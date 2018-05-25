

import command.CommandManager;

import javax.swing.*;

import static singleton.MediatorSingleton.getInstance;

public class TicToc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        print(getInstance().getCurrentPlayer() + " will turn first");
        while (getInstance().getStatusCode() == 3) {
            print(getInstance().getCurrentPlayer() + "'s turn");
            getInstance().move();
            getInstance().nextTurn();
            getInstance().updateCode();
        }
        CommandManager commandManager = new CommandManager();
        print(commandManager.end(getInstance().getStatusCode()));
    }

    public static void print(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
