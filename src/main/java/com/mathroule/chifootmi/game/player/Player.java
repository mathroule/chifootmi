package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;

/**
 * Abstract class for a game player.
 */
public abstract class Player {

    private final String name;

    private int win;

    private int loose;

    Player(String name) {
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

    /**
     * Pick a weapon from a list available of weapons.
     *
     * @param weapons the list available of weapons
     * @return the picked weapon
     */
    public abstract Weapon pickWeapon(List<Weapon> weapons);
}
