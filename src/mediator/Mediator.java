package mediator;

import objects.Game;
import objects.Player;

public class Mediator {
    int statusCode;
    String currentPlayer;
    boolean turn;
    Game game;
    Player player;

    public Mediator() {
    }

    public Mediator(int statusCode, String currentPlayer, Game game, Player player) {
        this.statusCode = statusCode;
        this.currentPlayer = currentPlayer;
        this.game = game;
        this.player = player;
        turn = false;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Mediator setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public Mediator setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
        return this;
    }

    public Game getGame() {
        return game;
    }

    public Mediator setGame(Game game) {
        this.game = game;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public Mediator setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public void init() {
        game = new Game();
        currentPlayer = player.toss();
        statusCode = game.gameStatus();
    }

    public void updateCode() {
        setStatusCode(game.gameStatus());
    }

    public boolean move() {
        int player = (turn) ? 1 : 0;
        return game.move(getMove(player), player);
    }

    private String getMove(int player) {
        return (player == 1) ? this.player.playerMove() : this.game.comMove();
    }

    public void nextTurn() {
        turn = !turn;
    }
}
