package com.mathroule.chifootmi.game.player;

/**
 * Abstract class for a game player.
 */
public abstract class Player {

    private String name;

    private int win;

    private int loose;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getLoose() {
        return loose;
    }

    public int getWin() {
        return win;
    }

    /**
     * Increment win counter.
     */
    public void won() {
        win++;
    }

    /**
     * Increment lose counter.
     */
    public void loose() {
        loose++;
    }
}
