package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;
import java.util.Random;

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

    @Override
    public String toString() {
        return name;
    }
}
