package objects;

import proxy.InputProxy;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Player {

    private String[] players;

    public Player(String pname) {
        players = new String[]{"Computer", pname};
    }

    public String toss() {
        int x = (int) Math.floor(Math.random() * 2);
        return players[x];
    }

    public String playerMove() {
        InputProxy inputProxy = new InputProxy();
        String move = JOptionPane.showInputDialog("Enter cell index-seprated by ',' (1,0)");
        while (inputProxy.proxyTest(move)) {
            move = JOptionPane.showInputDialog("Enter cell index-seprated by ',' (1,0)");
        }
        return move;
    }

    public int currentPlayer(String s) {
        return Arrays.asList(players).indexOf(s);
    }
}
