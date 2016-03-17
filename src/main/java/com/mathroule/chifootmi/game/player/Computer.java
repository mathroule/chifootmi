package com.mathroule.chifootmi.game.player;

import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.List;
import java.util.Random;

/**
 * Implementation class for a computer player.
 * TODO add AI to computer
 */
public final class Computer extends Player {

    /**
     * Computer available names.
     */
    private static final String[] AVAILABLE_NAMES = new String[]{
            "Ana",
            "Bob",
            "Paul"
    };

    /**
     * Computer player constructor using random name.
     */
    public Computer() {
        super(AVAILABLE_NAMES[new Random().nextInt(AVAILABLE_NAMES.length)]);
    }

    /**
     * Get a random weapon from a list available of weapons.
     *
     * @param weapons the list available of weapons
     * @return the selected weapon
     */
    public Weapon getRandomWeapon(List<Weapon> weapons) {
        int index = new Random().nextInt(weapons.size());
        return weapons.get(index);
    }
}
