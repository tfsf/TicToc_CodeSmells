package builder;
import javax.swing.*;

import objects.Player;
import mediator.Mediator;

public class GameBuilder {
    public Mediator makeGod(){
        Mediator god = new Mediator();
        god.setPlayer(new Player(JOptionPane.showInputDialog("Enter your name")));
        god.init();
        return god;
    }
}
