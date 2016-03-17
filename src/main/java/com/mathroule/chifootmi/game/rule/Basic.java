package com.mathroule.chifootmi.game.rule;


import com.mathroule.chifootmi.weapon.Paper;
import com.mathroule.chifootmi.weapon.Rock;
import com.mathroule.chifootmi.weapon.Scissors;
import com.mathroule.chifootmi.weapon.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement the basic games rules (i.e. Rock-paper-scissors).
 */
public class Basic extends Rules {

    // TODO convert to singleton

    // TODO @see: https://en.wikipedia.org/wiki/Interface_segregation_principle

    public Basic() {
        // Scissors cuts paper
        this.add(new Rule(new Scissors(), "cuts", new Paper()));

        // Paper covers rock
        this.add(new Rule(new Paper(), "covers", new Rock()));

        // Rock crushes scissors
        this.add(new Rule(new Rock(), "crushes", new Scissors()));
    }
}
