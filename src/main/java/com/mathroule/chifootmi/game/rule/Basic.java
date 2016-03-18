package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.game.weapon.Paper;
import com.mathroule.chifootmi.game.weapon.Rock;
import com.mathroule.chifootmi.game.weapon.Scissors;
import com.mathroule.chifootmi.game.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the basic games rules as singleton (i.e. Rock-paper-scissors).
 */
public final class Basic extends Rules {

    /**
     * Constructor of the basic game rules (i.e. Rock-paper-scissors).
     */
    private Basic() {
        // Rock crushes scissors
        this.add(new Rule(new Rock(), "crushes", new Scissors()));

        // Paper covers rock
        this.add(new Rule(new Paper(), "covers", new Rock()));

        // Scissors cuts paper
        this.add(new Rule(new Scissors(), "cuts", new Paper()));
    }

    @Override
    public final List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Rock());
        weapons.add(new Paper());
        weapons.add(new Scissors());
        return weapons;
    }

    private static class BasicHolder {
        private final static Basic instance = new Basic();
    }

    public static Basic getInstance() {
        return BasicHolder.instance;
    }
}
