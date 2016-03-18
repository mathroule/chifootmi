package com.mathroule.chifootmi.game.player;

/**
 * Abstract class for a game player.
 */
public abstract class Player {

    private final String name;

    private int win;

    private int loose;

    public Player(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public final int getLoose() {
        return loose;
    }

    public final int getWin() {
        return win;
    }

    /**
     * Increment win counter.
     */
    public final void won() {
        win++;
    }

    /**
     * Increment lose counter.
     */
    public final void loose() {
        loose++;
    }
}
