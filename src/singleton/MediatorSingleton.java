package singleton;

import mediator.Mediator;
import builder.GameBuilder;

public class MediatorSingleton {
    static Mediator god;

    private MediatorSingleton() {
    }

    public static Mediator getInstance() {
        if (god == null) {
            GameBuilder gameBuilder = new GameBuilder();
            god = gameBuilder.makeGod();
        }
        return god;
    }

}
