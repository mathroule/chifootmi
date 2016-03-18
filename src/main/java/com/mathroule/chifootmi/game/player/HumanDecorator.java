package com.mathroule.chifootmi.game.player;

/**
 * Abstract decorator class for an human player.
 */
public abstract class HumanDecorator extends Human {

    /**
     * Human player constructor using name.
     *
     * @param name the player name
     */
    public HumanDecorator(String name) {
        super(name);
    }
}
