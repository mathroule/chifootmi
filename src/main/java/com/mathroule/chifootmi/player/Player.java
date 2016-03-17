package com.mathroule.chifootmi.player;

/**
 * Abstract class for a game player.
 */
public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}